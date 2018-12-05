package com.foodbird.generate.java.codes;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public class Meta implements IMeta {

    private String name;

    public Meta(String name) {
        this.name = name;
    }

    @Override
    public String toCode() {
        return name;
    }
}
