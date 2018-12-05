package com.foodbird.generate.java.strategy.instance;

import com.foodbird.generate.java.codes.ICodeModel;
import com.foodbird.generate.java.strategy.ICodeGenerateStrategy;

/**
 * @author yy111026 on 2017/2/21.
 */
public class InstanceStrategy implements ICodeGenerateStrategy {

    @Override
    public String generate(ICodeModel model) {
        return model.toCode();
    }
}
