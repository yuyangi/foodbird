package com.foodbird.common.nlp.parser;

import java.util.Map;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/29
 */
public interface FBITokenizer<Source, Target> {

    FBITokenizer<Source, Target> source(Source s);

    //Source source();

    Map<Target[], Integer> evaluate(Target[][] splits);

    Target[][] split();

    boolean isCompleted();

}
