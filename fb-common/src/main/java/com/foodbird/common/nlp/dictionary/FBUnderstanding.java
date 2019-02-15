package com.foodbird.common.nlp.dictionary;

import com.foodbird.common.enums.FBUnderstandNature;
import com.foodbird.common.nlp.FBIUnderstanding;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/17
 */
public class FBUnderstanding<Subject> implements FBIUnderstanding<Subject> {

    private FBUnderstandNature nature;

    private Subject subject;

    public FBUnderstandNature getNature() {
        return nature;
    }

    public void setNature(FBUnderstandNature nature) {
        this.nature = nature;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Subject subject() {
        return subject;
    }

    @Override
    public FBUnderstandNature nature() {
        return nature;
    }
}
