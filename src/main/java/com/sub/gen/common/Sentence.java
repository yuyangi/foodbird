package com.sub.gen.common;

import com.sub.gen.constants.Constants;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public class Sentence extends Block implements Constants {

    private int rowLevel = 0;

    public Sentence() {
        super(WORD_SEPARATOR);
    }

    public Sentence(int rowLevel) {
        this();
        this.setRowLevel(rowLevel);
    }

    public int getRowLevel() {
        return rowLevel;
    }

    public void setRowLevel(int rowLevel) {
        this.rowLevel = rowLevel;
        for (int i = 0; i < rowLevel;i++) {
            this.getCodes().add(0, new Indent());
        }
    }

}
