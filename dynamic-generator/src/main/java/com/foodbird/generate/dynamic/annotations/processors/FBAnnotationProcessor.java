package com.foodbird.generate.dynamic.annotations.processors;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
public class FBAnnotationProcessor implements FBIAnnotationProcessor {

    private List<FBIAnnotationVisitor> visitors = Lists.newArrayList();

    @Override
    public List<FBIAnnotationVisitor> visitors() {
        return visitors;
    }

    public void registerVisitor(FBIAnnotationVisitor visitor) {
        visitors.add(visitor);
    }

    @Override
    public void unregisterVisitor(FBIAnnotationVisitor visitor) {
        visitors.remove(visitor);
    }
}
