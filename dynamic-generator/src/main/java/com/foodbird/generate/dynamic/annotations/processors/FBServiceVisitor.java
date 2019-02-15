package com.foodbird.generate.dynamic.annotations.processors;

import com.foodbird.generate.dynamic.annotations.FBService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

import java.util.Optional;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
public class FBServiceVisitor extends FBAbsAnnotationVisitor {

    public FBServiceVisitor(ListableBeanFactory beanFactory, BeanDefinitionRegistry registry) {
        super(beanFactory, registry);
    }

    @Override
    public void visit(String beanName) {
        Optional.ofNullable(beanFactory.findAnnotationOnBean(beanName, FBService.class))
                .ifPresent(fbService -> dic.load(loadService2Dic(beanName, fbService)));
    }

}
