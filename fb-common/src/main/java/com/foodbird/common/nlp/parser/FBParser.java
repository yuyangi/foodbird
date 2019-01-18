package com.foodbird.common.nlp.parser;

import com.foodbird.common.nlp.FBIDescription;
import com.foodbird.common.nlp.FBIWord;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/17
 */
public class FBParser implements FBIParser<FBIDescription, FBIWord> {

    private FBITokenizer<FBIDescription, FBIWord>  tokenizer;

    @Override
    public FBITokenizer<FBIDescription, FBIWord> tokenizer() {
        if (tokenizer == null) {
            tokenizer = new FBTokenizer();
        }
        return tokenizer;
    }

    public FBITokenizer<FBIDescription, FBIWord> getTokenizer() {
        return tokenizer;
    }

    public void setTokenizer(FBITokenizer<FBIDescription, FBIWord> tokenizer) {
        this.tokenizer = tokenizer;
    }
}
