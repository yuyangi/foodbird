package com.foodbird.common.nlp;

import java.util.List;

public interface FBIDictionary {

    FBIWord lookup(String word);

    FBIMeaning meaning(String word);

    boolean isWord(String word);

    String possibleWord(String word);

    void load(List<String> words);

}
