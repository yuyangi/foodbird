package com.foodbird.generate.java.common;

import com.foodbird.generate.java.ICoder;
import org.apache.commons.lang.ArrayUtils;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/7
 */
public class Phrase extends Section {
    public Phrase() {
        super(WORD_SEPARATOR);
    }

    public Phrase(String delimiter) {
        super(delimiter);
    }

    public static Phrase phrase(ICoder... coders) {
        return phrase(WORD_SEPARATOR, coders);
    }

    public static Phrase phrase(String delimiter, ICoder... coders) {
        Phrase p = new Phrase(delimiter);
        if (ArrayUtils.isEmpty(coders)) {
            return p;
        }
        for (ICoder coder : coders) {
            if (coder != null) {
                p.getCodes().add(coder);
            }
        }
        return p;
    }
}
