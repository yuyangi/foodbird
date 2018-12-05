package com.foodbird.generate.java.common;

import com.foodbird.generate.java.codes.metas.Brackets;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/30
 */
public class MethodBody extends Segment {

    public MethodBody() {
    }

    public MethodBody(List<Sentence> sentences) {
        super(sentences);
    }

    public String toCode() {
        getCodes().add(0, Brackets.LEFT_BRACKET);
        getCodes().add(Brackets.RIGHT_BRACKET);
        return super.toCode();
    }

}
