package com.foodbird.generate.java.codes.metas;

import com.foodbird.generate.java.codes.IMeta;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public enum Definitions implements IMeta {

    CLASS("class"),
    INTERFACE("interface"),
    ENUM("enum"),
    VOID("void"),
    RETURN("return"),
    EXTENDS("extends"),
    IMPLEMENTS("implements"),
    NEW("new")
    ;

    private String name;

    Definitions(String name) {
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
