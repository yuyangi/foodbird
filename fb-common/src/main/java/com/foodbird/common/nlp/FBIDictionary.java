package com.foodbird.common.nlp;

import java.util.List;

public interface FBIDictionary {

    FBIWord lookup(String word);

    FBIMeaning meaning(String word);

    boolean isWord(String word);

    String possibleWord(String word);

    void load(List<FBIWord<?>> words);

    void loadRaw(List<String> words);

    void load(FBIWord<?> word);

    void loadRaw(String word);

}
