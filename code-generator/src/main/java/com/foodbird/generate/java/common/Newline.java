package com.foodbird.generate.java.common;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.constants.Constants;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/6
 */
public class Newline implements ICoder, Constants {

    public static final Newline NEWLINE = new Newline();

    @Override
    public String toCode() {
        return LINE_SEPARATOR;
    }

    public static Newline get() {
        return NEWLINE;
    }

}
