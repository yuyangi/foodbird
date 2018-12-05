package com.foodbird.generate.java.common;

import com.foodbird.generate.java.ICoder;
import com.google.common.collect.Lists;
import org.apache.commons.lang.ArrayUtils;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public class Block implements ICoder {

    private String delimiter;
    private List<ICoder> codes;

    public Block(String delimiter) {
        this.codes = Lists.newArrayList();
        this.delimiter = delimiter;
    }

    @Override
    public String toCode() {
        StringJoiner joiner = new StringJoiner(delimiter);
        codes.stream().forEach(c -> joiner.add(c.toCode()));
        return joiner.toString();
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

    public static Block create(String delimiter, ICoder... coders) {
        Block b = new Block(delimiter);
        if (ArrayUtils.isEmpty(coders)) {
            return b;
        }
        for (ICoder coder : coders) {
            b.getCodes().add(coder);
        }
        return b;
    }
}
