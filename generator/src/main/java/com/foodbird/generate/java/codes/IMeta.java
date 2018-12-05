package com.foodbird.generate.java.codes;

import com.foodbird.generate.java.ICoder;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public interface IMeta extends ICoder {

    default int index() {
        return 0;
    }

}
