package com.foodbird.common.nlp.dictionary;

import com.foodbird.common.nlp.FBIDictionary;
import com.foodbird.common.nlp.FBIMeaning;
import com.foodbird.common.nlp.FBIWord;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/17
 */
public class FBDictionary implements FBIDictionary {

    private List<String> words;

    @Override
    public FBIWord lookup(String word) {
        if (words.contains(word)) {
            return new FBWord(word);
        }
        return null;
    }

    @Override
    public FBIMeaning meaning(String word) {
        return null;
    }

    @Override
    public String possibleWord(String word) {
        return null;
    }

    @Override
    public boolean isWord(String word) {
        return words.contains(word);
    }

    @Override
    public void load(List<String> words) {
        this.words = words;
    }

}
