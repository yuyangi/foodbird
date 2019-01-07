package com.foodbird.generate.dynamic.component;

import com.alibaba.fastjson.parser.ParserConfig;
import com.foodbird.generate.dynamic.annotations.fbact;
import com.foodbird.generate.dynamic.annotations.fbsvc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yuyang48
 * @date 2018/11/9
 */
@Component
public class FBBeanRegistryProcessor implements
        BeanDefinitionRegistryPostProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(FBBeanRegistryProcessor.class);

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
            File[] propertiesFiles = base.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return (pathname.isFile() && pathname.getName().endsWith(".properties"))
                            || (pathname.isDirectory() && pathname.getName().toLowerCase().contains("config"));
                }
            });
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
        registerBeanSingleton(beanName, clz);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, fbsvc> beanNameWithFBServices =
                Arrays.stream(beanFactory.getBeanNamesForAnnotation(fbsvc.class)).
                        collect(Collectors.toMap(Function.identity(), name -> beanFactory.findAnnotationOnBean(name, fbsvc.class)));

        registerWithAnnotations(beanFactory, beanNameWithFBServices);
    }

    private void registerWithAnnotations(BeanFactory beanFactory, Map<String, fbsvc> beanNameWithFBServices) {
        beanNameWithFBServices.forEach((k, v) -> collectBeans(beanFactory, k, v));
    }

    private void collectBeans(BeanFactory beanFactory, String beanName, fbsvc service) {
        Class<?> type = beanFactory.getType(beanName);
        Method[] declaredMethods = type.getDeclaredMethods();
        for (Method method : declaredMethods) {
            fbact action = method.getAnnotation(fbact.class);
            if (action != null) {
                // TODO yuyang register beans.
            }
        }
    }

}
