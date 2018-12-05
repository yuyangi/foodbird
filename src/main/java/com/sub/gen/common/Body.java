package com.sub.gen.common;

import com.sub.gen.codes.metas.Brackets;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/30
 */
public class Body extends Segment {

    public Body() {
    }

    public Body(List<Sentence> sentences) {
        super(sentences);
    }

    public String toCode() {
        getCodes().add(0, Brackets.LEFT_BRACKET);
        getCodes().add(Brackets.RIGHT_BRACKET);
        return super.toCode();
    }

}
