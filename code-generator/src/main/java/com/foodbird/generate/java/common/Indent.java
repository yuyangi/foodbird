package com.foodbird.generate.java.common;


import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.constants.Constants;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public class Indent implements ICoder, Constants {

    public static final Indent instance = new Indent();

    @Override
    public String toCode() {
        return INDENT;
    }

}
