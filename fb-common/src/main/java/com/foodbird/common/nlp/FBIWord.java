package com.foodbird.common.nlp;

public interface FBIWord extends FBIUnderstanding {

    String word();

    int index();

    FBIMeaning meaning();

}
