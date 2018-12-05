package com.foodbird.generate.java.strategy;

import com.foodbird.generate.java.codes.ICodeModel;

/**
 * @author yy111026 on 2017/2/21.
 */
public class DefaultCodeGenerateStrategy implements ICodeGenerateStrategy {

    @Override
    public String generate(ICodeModel model) {
        return model.toCode();
    }
}
