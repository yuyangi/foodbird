package com.foodbird.generate.java.common;


import com.foodbird.generate.java.ICoder;

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
