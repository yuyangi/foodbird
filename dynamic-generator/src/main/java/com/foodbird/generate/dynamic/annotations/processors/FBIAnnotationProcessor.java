package com.foodbird.generate.dynamic.annotations.processors;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
public interface FBIAnnotationProcessor {

    List<FBIAnnotationVisitor> visitors();

    void registerVisitor(FBIAnnotationVisitor visitor);

    void unregisterVisitor(FBIAnnotationVisitor visitor);

    default void process(String beanName) {
        visitors().forEach(v -> v.visit(beanName));
    }

}
