package com.sub.gen.strategy.elem;

import com.sub.gen.meta.ICodeModel;
import com.sub.gen.strategy.IGenMetaStrategy;

/**
 * Created by yy111026 on 2017/2/10.
 */
public abstract class AbstractGenMetaStrategy implements IGenMetaStrategy {

    public AbstractGenMetaStrategy() {
    }

    @Override
    public String defineForm(ICodeModel model) {
        return model.toCode();
    }

}
