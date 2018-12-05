package com.sub.gen.codes.metas;

import com.sub.gen.codes.IMeta;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public enum Modifiers implements IMeta {

    PUBLIC("public"),
    PROTECTED("protected"),
    PRIVATE("private"),
    DEFALUT("defalut"),

    STATIC("static"),
    FINAL("final"),
    ABSTRACT("abstract"),
    SYNCHRONIZED("synchronized"),
    TRANSIENT("transient"),
    VOLATILE("volatile")
    ;

    private String name;

    Modifiers(String name) {
        this.name = name;
    }

    @Override
    public String toCode() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
