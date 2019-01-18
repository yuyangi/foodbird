package com.foodbird.common.nlp.dictionary;

import com.foodbird.common.nlp.FBIMeaning;
import com.foodbird.common.nlp.FBIWord;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/17
 */
public class FBWord extends FBUnderstanding implements FBIWord {

    private String word;

    private int index;

    private FBIMeaning meaning;

    public FBWord(String word) {
        this.word = word;
    }

    @Override
    public String word() {
        return word;
    }

    @Override
    public int index() {
        return index;
    }

    @Override
    public FBIMeaning meaning() {
        return meaning;
    }

}
