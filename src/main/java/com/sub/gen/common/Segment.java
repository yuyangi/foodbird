package com.sub.gen.common;

import com.sub.gen.constants.Constants;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public class Segment extends Block implements Constants {

    private List<Sentence> sentences;

    public Segment() {
        super(LINE_SEPARATOR);
    }

    public Segment(List<Sentence> sentences) {
        super(LINE_SEPARATOR);
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }
}
