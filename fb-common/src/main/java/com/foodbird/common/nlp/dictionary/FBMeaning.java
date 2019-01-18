package com.foodbird.common.nlp.dictionary;

import com.foodbird.common.enums.FBUnderstandNature;
import com.foodbird.common.nlp.FBIMeaning;
import com.foodbird.common.nlp.FBIWord;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/17
 */
public class FBMeaning extends FBUnderstanding implements FBIMeaning {

    private FBIWord[] opposites;

    private FBIWord[] similars;

    private FBIWord[] relevants;

    @Override
    public FBIWord[] opposites() {
        return new FBIWord[0];
    }

    @Override
    public FBIWord[] similars() {
        return new FBIWord[0];
    }

    @Override
    public FBIWord[] relevants() {
        return new FBIWord[0];
    }

}
