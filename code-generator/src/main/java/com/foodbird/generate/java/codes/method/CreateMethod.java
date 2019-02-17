package com.foodbird.generate.java.codes.method;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.common.Section;
import com.foodbird.generate.java.common.Body;
import com.foodbird.generate.java.common.Word;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/5
 */
public class CreateMethod extends Method {

    public CreateMethod() {
        super();
        this.setName("创建");
    }

    @Override
    public Body methodBody() {
        List<ICoder> codes = Lists.newArrayList();
        Section block = Body.create(Body.LINE_SEPARATOR, codes.toArray(new ICoder[0]));
        Body body = new Body();
        body.add(block);
        return body;
    }

    @Override
    public Word methodName() {
        return null;
    }
}
