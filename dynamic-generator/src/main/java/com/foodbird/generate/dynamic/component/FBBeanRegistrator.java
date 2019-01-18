package com.foodbird.generate.dynamic.component;

import com.alibaba.fastjson.parser.ParserConfig;
import com.foodbird.common.nlp.FBIDictionary;
import com.foodbird.common.nlp.dictionary.FBDictionaryFactory;
import com.foodbird.generate.dynamic.FBActionImpl;
import com.foodbird.generate.dynamic.FBIAction;
import com.foodbird.generate.dynamic.FBServiceImpl;
import com.foodbird.generate.dynamic.annotations.FBAction;
import com.foodbird.generate.dynamic.annotations.FBService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileFilter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yuyangi
 * @date
 * @prject com.foodbird.com
 */
@Component
public class FBBeanRegistrator implements BeanDefinitionRegistryPostProcessor, EnvironmentAware, ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(FBBeanRegistrator.class);

    private Environment environment;

    private ApplicationContext applicationContext;

    private BeanDefinitionRegistry registry;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        this.registry = registry;
    }

    /**
     * 加载根目录下和名称包含config目录下的*.properties文件
     *
     * @return Resources
     */
    private Resource[] loadResources() {
        String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource("")).getPath();
        File base = new File(path);
        List<Resource> resources = new ArrayList<>();
        if (base.isDirectory()) {
            File[] propertiesFiles = base.listFiles(pathname -> (pathname.isFile() && pathname.getName().endsWith(".properties"))
                    || (pathname.isDirectory() && pathname.getName().toLowerCase().contains("config")));
            if (propertiesFiles != null && propertiesFiles.length > 0) {
                for (File propertyFile : propertiesFiles) {
                    if (propertyFile.isFile()) {
                        resources.add(new FileSystemResource(propertyFile));
                    } else if (propertyFile.isDirectory()) {
                        File[] subFiles = propertyFile.listFiles(new FileFilter() {
                            @Override
                            public boolean accept(File pathname) {
                                return pathname.isFile() && pathname.getName().endsWith(".properties");
                            }
                        });
                        if (subFiles != null)
                            for (File subFile : subFiles) {
                                resources.add(new FileSystemResource(subFile));
                            }
                    }
                }
            }
        }
        return resources.toArray(new Resource[0]);
    }

    private void registerBeanSingleton(String beanName, Class<?> clz) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clz);
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        beanDefinition.setScope(ConfigurableBeanFactory.SCOPE_SINGLETON);
        registry.registerBeanDefinition(beanName, beanDefinition);
    }

    private void registerBean(String beanName, Class<?> clz) {
        registerBean(beanName, clz, null, null, null);
    }

    private void registerBean(String beanName, Class<?> clz, List<PropertyValue> propertyValues) {
        registerBean(beanName, clz, propertyValues, null, null);
    }

    private void registerBean(String beanName, Class<?> clz, List<PropertyValue> propertyValues, List<?> constructorArgs, String initMethod) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clz);
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();

        if (CollectionUtils.isNotEmpty(constructorArgs)) {
            ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
            for (Object arg : constructorArgs) {
                constructorArgumentValues.addGenericArgumentValue(arg);
            }
            beanDefinition.setConstructorArgumentValues(constructorArgumentValues);
        }

        if (CollectionUtils.isNotEmpty(propertyValues)) {
            beanDefinition.setPropertyValues(new MutablePropertyValues(propertyValues));
        }

        if (StringUtils.isNotEmpty(initMethod)) {
            beanDefinition.setInitMethodName(initMethod);
        }

        beanDefinition.setScope(ConfigurableBeanFactory.SCOPE_SINGLETON);
        registry.registerBeanDefinition(beanName, beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, FBService> beanNameWithFBServices =
                Arrays.stream(beanFactory.getBeanNamesForAnnotation(FBService.class)).
                        collect(Collectors.toMap(Function.identity(), name -> beanFactory.findAnnotationOnBean(name, FBService.class)));

        registerWithAnnotations(beanFactory, beanNameWithFBServices);
    }

    private void registerWithAnnotations(BeanFactory beanFactory, Map<String, FBService> beanNameWithFBServices) {
        beanNameWithFBServices.forEach((beanName, service) -> registerBeans(beanFactory, beanName, service));
    }

    private void registerBeans(BeanFactory beanFactory, String beanName, FBService service) {
        Map<String, List<FBIAction<?>>> serviceActions = Maps.newHashMap();
        Arrays.stream(beanFactory.getType(beanName).getDeclaredMethods()).
                forEach(method -> Optional.of(method.getAnnotation(FBAction.class)).
                        ifPresent(action -> serviceActions.computeIfAbsent(action.id(), k -> Lists.newArrayList()).
                                add(new FBActionImpl<>(beanFactory.getBean(beanName), method, action))));
        serviceActions.forEach((serviceId, actions) ->
                registerBean(serviceId, FBServiceImpl.class, null, Arrays.asList(serviceId, actions), FBServiceImpl.INIT_METHOD));
    }

    private void loadService2Dic(BeanFactory beanFactory, String beanName, FBService service) {
        try {
            FBIDictionary dic = FBDictionaryFactory.load("");// DIC name 选择
        } catch (Exception e) {
            LOGGER.error("加载字典失败！", e);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
