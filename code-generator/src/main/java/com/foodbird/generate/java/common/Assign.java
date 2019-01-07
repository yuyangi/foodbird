package com.foodbird.generate.java.common;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.codes.metas.Operators;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/6
 */
public class Assign extends Section {

    private ICoder left;
    private ICoder right;

    public Assign(ICoder left, ICoder right) {
        super(WORD_SEPARATOR);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toCode() {
        return Sentence.sentence(left, Operators.ASSIGN, right).end().toCode();
    }

    public static Assign create(ICoder left, ICoder right) {
        return new Assign(left, right);
    }

}
