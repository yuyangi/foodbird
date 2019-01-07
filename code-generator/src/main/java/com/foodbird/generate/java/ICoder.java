package com.foodbird.generate.java;

/**
 * Created by yuyang on 2016/11/26.
 */
public interface ICoder {

    String toCode();

    default String comments() {
        return "";
    }

}
