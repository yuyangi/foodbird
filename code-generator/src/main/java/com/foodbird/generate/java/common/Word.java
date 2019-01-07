package com.foodbird.generate.java.common;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/5
 */
public class Word extends Section {

    private String word;

    public Word(String word) {
        super("");
        this.word = word;
    }

    @Override
    public String toCode() {
        return word;
    }

    public static Word create(String word) {
        return new Word(word);
    }
}
