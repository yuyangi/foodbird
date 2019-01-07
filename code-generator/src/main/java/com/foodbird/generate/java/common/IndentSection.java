package com.foodbird.generate.java.common;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.codes.Indented;
import org.apache.commons.lang.ArrayUtils;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/7
 */
public class IndentSection extends Section implements Indented {

    public IndentSection(String delimiter) {
        super(delimiter);
        this.setPassed(true);
    }

    public IndentSection() {
        this(LINE_SEPARATOR);
    }

    public static IndentSection create(String delimiter, ICoder... coders) {
        IndentSection b = new IndentSection(delimiter);
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

    public static IndentSection create(ICoder... coders) {
        return create(LINE_SEPARATOR, coders);
    }

}
