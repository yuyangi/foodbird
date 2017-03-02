package com.sub.gen.strategy.form;

import com.sub.gen.meta.ICodeModel;
import com.sub.gen.strategy.ICodeGenerateStrategy;

/**
 * Created by yy111026 on 2017/2/14.
 */
public class DefaultFormStrategy implements ICodeGenerateStrategy {

    @Override
    public String generate(ICodeModel model) {
        return model.toCode();
    }
}
