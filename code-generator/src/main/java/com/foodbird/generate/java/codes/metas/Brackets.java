package com.foodbird.generate.java.codes.metas;

import com.foodbird.generate.java.codes.IMeta;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/30
 */
public enum Brackets implements IMeta {

    LEFT_SQUARE_BRACKET("["),
    RIGHT_SQUARE_BRACKET("]"),
    LEFT_BRACKET("{"),
    RIGHT_BRACKET("}"),
    LEFT_PARENTHESIS("("),
    RIGHT_PARENTHESIS(")")
    ;

    public static Brackets[] BRACKETS = new Brackets[] {LEFT_BRACKET, RIGHT_BRACKET};
    public static Brackets[] SQUARE_BRACKET = new Brackets[] {LEFT_SQUARE_BRACKET, RIGHT_SQUARE_BRACKET};
    public static Brackets[] PARENTHESIS = new Brackets[] {LEFT_PARENTHESIS, RIGHT_PARENTHESIS};

    private String code;

    Brackets(String code) {
        this.code = code;
    }

    @Override
    public String toCode() {
        return code;
    }
}
