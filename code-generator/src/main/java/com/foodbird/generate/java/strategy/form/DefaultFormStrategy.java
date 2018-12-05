package com.foodbird.generate.java.strategy.form;

import com.foodbird.generate.java.codes.ICodeModel;
import com.foodbird.generate.java.strategy.ICodeGenerateStrategy;

/**
 * Created by yy111026 on 2017/2/14.
 */
public class DefaultFormStrategy implements ICodeGenerateStrategy {

    @Override
    public String generate(ICodeModel model) {
        return model.toCode();
    }
}
