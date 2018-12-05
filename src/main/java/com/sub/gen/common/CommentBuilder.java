package com.sub.gen.common;

import com.sub.gen.ICoder;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public class CommentBuilder implements ICoder {

    private ICoder coder;

    public CommentBuilder(ICoder coder) {
        this.coder = coder;
    }

    @Override
    public String toCode() {
        return null;
    }

}
