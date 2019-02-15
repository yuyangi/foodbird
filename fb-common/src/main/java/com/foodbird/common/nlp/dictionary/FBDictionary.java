package com.foodbird.common.nlp.dictionary;

import com.foodbird.common.nlp.FBIDictionary;
import com.foodbird.common.nlp.FBIMeaning;
import com.foodbird.common.nlp.FBIWord;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/17
 */
public class FBDictionary implements FBIDictionary {

    private List<String> rawWords;

    private List<FBIWord<?>> words;

    @Override
    public FBIWord lookup(String word) {
        int index;
        if ((index = rawWords.indexOf(word)) > 0) {
            return words.get(index);
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
    public void load(List<FBIWord<?>> words) {
        if (this.words == null) {
            this.words = Lists.newArrayList();
        }
        this.words.addAll(words);
        if (rawWords == null) {
            rawWords = Lists.newArrayList();
        }
        for (FBIWord<?> word : words) {
            rawWords.add(word.word());
        }
    }

    @Override
    public void loadRaw(List<String> rawWords) {
        this.rawWords = rawWords;
        if (this.words == null) {
            this.words = Lists.newArrayList();
        }
        if (rawWords != null) {
            for (String rawWord : rawWords) {
                FBIWord<?> word = new FBWord<>(rawWord);
                this.words.add(word);
            }
        }
    }

    @Override
    public void load(FBIWord<?> word) {
        if (this.words == null) {
            this.words = Lists.newArrayList();
        }
        this.words.add(word);
        if (rawWords == null) {
            rawWords = Lists.newArrayList();
        }
        rawWords.add(word.word());
    }

    @Override
    public void loadRaw(String rawWord) {
        if (this.words == null) {
            this.words = Lists.newArrayList();
        }
        if (rawWord != null) {
            FBIWord<?> word = new FBWord<>(rawWord);
            this.words.add(word);
        }
    }
}
