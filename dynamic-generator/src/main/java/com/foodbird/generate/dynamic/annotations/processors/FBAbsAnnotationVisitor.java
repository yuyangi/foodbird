package com.foodbird.generate.dynamic.annotations.processors;

import com.foodbird.common.enums.FBWordType;
import com.foodbird.common.nlp.FBIDictionary;
import com.foodbird.common.nlp.FBIWord;
import com.foodbird.common.nlp.dictionary.FBDictionary;
import com.foodbird.common.nlp.dictionary.FBDictionaryFactory;
import com.foodbird.common.nlp.dictionary.FBWord;
import com.foodbird.generate.dynamic.FBActionImpl;
import com.foodbird.generate.dynamic.FBIAction;
import com.foodbird.generate.dynamic.FBServiceImpl;
import com.foodbird.generate.dynamic.annotations.FBAction;
import com.foodbird.generate.dynamic.annotations.FBOperation;
import com.foodbird.generate.dynamic.annotations.FBProcess;
import com.foodbird.generate.dynamic.annotations.FBService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
public abstract class FBAbsAnnotationVisitor implements FBIAnnotationVisitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(FBAbsAnnotationVisitor.class);

    protected ListableBeanFactory beanFactory;

    private BeanDefinitionRegistry registry;

    protected static FBIDictionary dic;

    static {
        try {
            dic = FBDictionaryFactory.load(FBDictionaryFactory.DEFAULT_DICTIONARY);
        } catch (Exception e) {
            LOGGER.error("加载字典失败！", e);
            dic = new FBDictionary();
        }
    }

    public FBAbsAnnotationVisitor(ListableBeanFactory beanFactory, BeanDefinitionRegistry registry) {
        this.beanFactory = beanFactory;
        this.registry = registry;
    }

    protected void registerBeans(String beanName, FBProcess process) {
        Map<String, List<FBIAction<?>>> serviceActions = Maps.newHashMap();
        Optional.ofNullable(beanFactory.getType(beanName)).ifPresent(clz -> Arrays.stream(clz.getDeclaredMethods())
                .filter(m -> !Modifier.isVolatile(m.getModifiers()))
                .forEach(method -> Optional.ofNullable(method.getAnnotation(FBAction.class))
                        .ifPresent(action -> serviceActions.computeIfAbsent(action.id(), k -> Lists.newArrayList())
                                .add(new FBActionImpl<>(beanFactory.getBean(beanName), method, action)))));
        serviceActions.forEach((serviceId, actions) ->
                registerBean(serviceId, FBServiceImpl.class, null, Arrays.asList(serviceId, actions), FBServiceImpl.INIT_METHOD));
    }

    protected List<FBIWord<?>> loadService2Dic(String beanName, FBService service) {
        List<FBIWord<?>> words = Lists.newArrayList();
        Optional.ofNullable(beanFactory.getType(beanName))
                .ifPresent(clz -> Arrays.stream(clz.getDeclaredMethods()).filter(m -> !Modifier.isVolatile(m.getModifiers()))
                        .forEach(method -> Optional.ofNullable(method.getAnnotation(FBOperation.class))
                                .ifPresent(operation -> words.add(new FBWord<FBOperation>(operation.name(), operation, FBWordType.v)))));
        return words;
    }

    protected void registerBean(String beanName, Class<?> clz, List<PropertyValue> propertyValues, List<?> constructorArgs, String initMethod) {
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

}
