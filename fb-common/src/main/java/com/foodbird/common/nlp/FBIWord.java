package com.foodbird.common.nlp;

import com.foodbird.common.enums.FBWordType;

public interface FBIWord<S> extends FBIUnderstanding<S> {

    String word();

    int index();

    FBWordType wordType();

    FBIMeaning meaning();

}
