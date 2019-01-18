package com.foodbird.common.nlp;

public interface FBIMeaning extends FBIUnderstanding {

    FBIWord[] opposites();

    FBIWord[] similars();

    FBIWord[] relevants();

}
