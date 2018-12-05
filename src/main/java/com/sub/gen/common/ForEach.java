package com.sub.gen.common;

import com.sub.gen.constants.Constants;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public class ForEach extends Block implements Constants {

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
