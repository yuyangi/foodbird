package com.foodbird.common.nlp;

import com.foodbird.common.enums.FBUnderstandNature;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/29
 */
public interface FBIUnderstanding<Subject> {

    FBUnderstandNature nature();

    Subject subject();
}
