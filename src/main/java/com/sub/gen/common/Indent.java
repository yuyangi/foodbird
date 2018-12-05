package com.sub.gen.common;

import com.sub.gen.ICoder;
import com.sub.gen.constants.Constants;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public class Indent implements ICoder, Constants {

    @Override
    public String toCode() {
        return INDENT;
    }

}
