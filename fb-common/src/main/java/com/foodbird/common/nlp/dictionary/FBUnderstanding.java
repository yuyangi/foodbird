package com.foodbird.common.nlp.dictionary;

import com.foodbird.common.enums.FBUnderstandNature;
import com.foodbird.common.nlp.FBIUnderstanding;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/17
 */
public class FBUnderstanding implements FBIUnderstanding {

    private FBUnderstandNature nature;

    @Override
    public FBUnderstandNature nature() {
        return nature;
    }
}
