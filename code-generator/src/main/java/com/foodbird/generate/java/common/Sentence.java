package com.foodbird.generate.java.common;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.codes.metas.Charactor;
import com.foodbird.generate.java.constants.Constants;
import org.apache.commons.lang.ArrayUtils;

import java.util.StringJoiner;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public class Sentence extends IndentSection implements Constants {

    private int rowLevel = 0;

    public Sentence() {
        this(WORD_SEPARATOR);
    }

    public Sentence(String delimiter) {
        super(delimiter);
        this.setPassed(false);
    }

    public boolean withEnd;

    public Sentence(int rowLevel) {
        this();
        this.setRowLevel(rowLevel);
    }

    public Sentence comments(String comments) {
        this.comments = comments;
        return this;
    }

    public Sentence end() {
        withEnd = true;
        return this;
    }

    @Override
    public String toCode() {
        StringJoiner joiner;
        if (withEnd) {
            joiner = new StringJoiner(getDelimiter(), "", Charactor.SEMICOLON.toCode());
        } else {
            joiner = new StringJoiner(getDelimiter());
        }
        getCodes().stream().map(ICoder::toCode).forEach(joiner::add);
        return getIndent() != null ? getIndent() + joiner.toString() : joiner.toString();
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

    public static Sentence sentence(ICoder... coders) {
        return sentence(WORD_SEPARATOR, coders);
    }

    public static Sentence sentence(String delimiter, ICoder... coders) {
        Sentence b = new Sentence(delimiter);
        if (ArrayUtils.isEmpty(coders)) {
            return b;
        }
        for (ICoder coder : coders) {
            if (coder != null) {
                b.getCodes().add(coder);
            }
        }
        return b;
    }

}
