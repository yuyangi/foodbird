package com.foodbird.generate.java.common;

import com.foodbird.generate.java.constants.Constants;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public class ForEach extends Section implements Constants {

    private boolean isLambda = true;

    public ForEach() {
        super("");
    }

    public boolean isLambda() {
        return isLambda;
    }

    public void setLambda(boolean lambda) {
        isLambda = lambda;
    }
}
