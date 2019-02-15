package com.foodbird.generate.dynamic.annotations.processors;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
public class FBAnnotationProcessorFactory {

    public static FBIAnnotationProcessor create(ListableBeanFactory factory, BeanDefinitionRegistry registry) {
        FBProcessorVisitor processorVisitor = new FBProcessorVisitor(factory, registry);
        FBServiceVisitor serviceVisitor = new FBServiceVisitor(factory, registry);
        FBIAnnotationProcessor processor = new FBAnnotationProcessor();
        processor.registerVisitor(processorVisitor);
        processor.registerVisitor(serviceVisitor);
        return processor;
    }

}
