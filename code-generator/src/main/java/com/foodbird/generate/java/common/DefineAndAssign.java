package com.foodbird.generate.java.common;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.codes.IType;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/6
 */
public class DefineAndAssign extends Assign {

    public DefineAndAssign(IType type, String name, ICoder value) {
        super(Sentence.sentence(type, Word.create(name)), value);
    }

}
