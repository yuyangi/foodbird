package com.sub.gen.strategy.elem;

import com.sub.gen.meta.ICodeModel;
import com.sub.gen.strategy.ICodeElemStrategy;

/**
 * Created by yy111026 on 2017/2/10.
 */
public abstract class AbstractCodeElemStrategy implements ICodeElemStrategy {

    public AbstractCodeElemStrategy() {
    }

    @Override
    public String defineForm(ICodeModel attribute) {
        return attribute.toCode();
    }

}
