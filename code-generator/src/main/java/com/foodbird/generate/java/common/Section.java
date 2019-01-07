package com.foodbird.generate.java.common;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.codes.Indented;
import com.foodbird.generate.java.constants.Constants;
import com.google.common.collect.Lists;
import org.apache.commons.lang.ArrayUtils;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public class Section implements ICoder, Constants {

    private String delimiter;
    private List<ICoder> codes;
    protected String comments;
    private String indent;
    private boolean passed;

    public Section(String delimiter) {
        this.codes = Lists.newArrayList();
        this.delimiter = delimiter;
    }

    @Override
    public String toCode() {
        StringJoiner joiner = new StringJoiner(delimiter);
        for (ICoder c : codes) {
            if (indent != null && c instanceof Indented) {
                //if (!isPassed()) {
                    ((Indented) c).setIndent(indent);
                //}
            }
            joiner.add(c.toCode());
        }
        return joiner.toString();
    }

    public String comments() {
        return comments;
    }

    public Section comments(String comments) {
        this.comments = comments;
        return this;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public List<ICoder> getCodes() {
        return codes;
    }

    public void setCodes(List<ICoder> codes) {
        this.codes = codes;
    }

    public String getIndent() {
        return indent;
    }

    public void setIndent(String indent) {
        if (isPassed()) {
            this.indent = indent;
        } else {
            this.indent = (this.indent == null) ? indent : (this.indent + indent);
            if (delimiter.startsWith(LINE_SEPARATOR) && this.indent != null) {
                delimiter = delimiter + this.indent;
            }
        }

    }

    public Section indent(String indent) {
        this.setIndent(indent);
        return this;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    public static Section create(String delimiter, ICoder... coders) {
        Section b = new Section(delimiter);
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

    public static Section create(ICoder... coders) {
        return create(LINE_SEPARATOR, coders);
    }

}
