package com.foodbird.common.nlp.dictionary;

import com.foodbird.common.enums.FBUnderstandNature;
import com.foodbird.common.enums.FBWordType;
import com.foodbird.common.nlp.FBIMeaning;
import com.foodbird.common.nlp.FBIWord;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/17
 */
public class FBWord<S> implements FBIWord {

    private String word;

    private int index;

    private FBIMeaning meaning;

    private FBWordType wordType;

    private FBUnderstandNature nature;

    private S subject;

    public FBWord(String word) {
        this.word = word;
    }

    public FBWord(String word, S subject, FBWordType wordType) {
        this.word = word;
        this.subject = subject;
        this.wordType = wordType;
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

    @Override
    public FBWordType wordType() {
        return wordType;
    }

    @Override
    public FBUnderstandNature nature() {
        return nature;
    }

    @Override
    public Object subject() {
        return subject;
    }

    public void setNature(FBUnderstandNature nature) {
        this.nature = nature;
    }

    public void setSubject(S subject) {
        this.subject = subject;
    }
}
