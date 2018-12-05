package com.sub.gen.strategy.instance;

import com.sub.gen.codes.ICodeModel;
import com.sub.gen.strategy.ICodeGenerateStrategy;

/**
 * @author yy111026 on 2017/2/21.
 */
public class InstanceStrategy implements ICodeGenerateStrategy {

    @Override
    public String generate(ICodeModel model) {
        return model.toCode();
    }
}
