package com.sub.common.gen.strategy.elem;

import com.sub.common.gen.meta.ICodeModel;
import com.sub.common.gen.strategy.ICodeElemStrategy;

/**
 * Created by yy111026 on 2017/2/10.
 */
public abstract class AbstractCodeElemStrategy implements ICodeElemStrategy {

    private ICodeModel model;

    public AbstractCodeElemStrategy(ICodeModel model) {
        this.model = model;
    }

    @Override
    public String defineForm() {
        return model.toCode();
    }

    public ICodeModel getModel() {
        return model;
    }

    public void setModel(ICodeModel model) {
        this.model = model;
    }

}
