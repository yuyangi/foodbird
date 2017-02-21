package com.sub.gen.strategy.meta;

import com.sub.gen.enums.MetaType;
import com.sub.gen.exception.UnsupportedFormException;
import com.sub.gen.meta.ICodeModel;
import com.sub.gen.strategy.IGenMetaStrategy;

/**
 * Created by yy111026 on 2017/2/10.
 */
public abstract class AbstractGenMetaStrategy implements IGenMetaStrategy {

    private MetaType metaType;

    public AbstractGenMetaStrategy(MetaType metaType) {
        this.metaType = metaType;
    }

    @Override
    public String defineForm(ICodeModel model) {
        return model.toCode();
    }

    protected void validate(ICodeModel model) throws UnsupportedFormException {
        if (model == null || model.getMetaType() != metaType) {
            throw new UnsupportedFormException();
        }
    }

}
