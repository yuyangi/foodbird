package com.foodbird.generate.java.strategy.meta;

import com.foodbird.generate.java.codes.ICodeModel;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.exception.UnsupportedFormException;
import com.foodbird.generate.java.strategy.ICodeGenerateStrategy;
import com.foodbird.generate.java.strategy.IGenMetaStrategy;

/**
 * Created by yy111026 on 2017/2/10.
 */
public abstract class AbstractGenMetaStrategy implements IGenMetaStrategy, ICodeGenerateStrategy {

    public AbstractGenMetaStrategy() {
    }

    @Override
    public String defineForm(ICodeModel model) {
        return model.toCode();
    }

    protected void validate(ICodeModel model, MetaType metaType) throws UnsupportedFormException {
        if (model == null || model.getMetaType() != metaType) {
            throw new UnsupportedFormException();
        }
    }

    @Override
    public String generate(ICodeModel model) {
        return model.toCode();
    }
}
