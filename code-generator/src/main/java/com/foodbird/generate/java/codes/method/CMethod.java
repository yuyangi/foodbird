package com.foodbird.generate.java.codes.method;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.common.Block;
import com.foodbird.generate.java.common.MethodBody;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/5
 */
public class CMethod extends Method {
    @Override
    public MethodBody methodBody() {
        List<ICoder> codes = Lists.newArrayList();
        Block block = MethodBody.create(MethodBody.LINE_SEPARATOR, codes.toArray(new ICoder[0]));
        MethodBody body = new MethodBody();
        return null;
    }
}
