package com.foodbird.generate.java.codes.metas;

import com.foodbird.generate.java.codes.IMeta;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/6
 */
public enum This implements IMeta {

    THIS("this")
    ;

    private String code;

    This(String code) {
        this.code = code;
    }

    @Override
    public String toCode() {
        return code;
    }
}
