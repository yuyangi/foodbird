package com.sub.gen.strategy.meta;

import com.sub.gen.enums.MetaType;
import com.sub.gen.exception.UnsupportedFormException;
import com.sub.gen.meta.ICodeModel;
import com.sub.gen.meta.IParameter;

/**
 * @author  yy111026
 * 2017/2/9.
 */
public class ReferenceCodeMetaStrategy extends AbstractGenMetaStrategy {

    public ReferenceCodeMetaStrategy(MetaType metaType) {
        super(metaType);
    }

    @Override
    public String defineForm(ICodeModel model) {
        return model.toCode();
    }

    @Override
    public String stateForm(ICodeModel model) throws UnsupportedFormException {
        return invokeForm(model);
    }

    @Override
    public String invokeForm(ICodeModel model, IParameter... parameters) throws UnsupportedFormException  {
        if (model.getMetaType() != MetaType.Reference) {
            throw new UnsupportedFormException();
        }

        return null;
    }

    @Override
    public String variableForm(ICodeModel model, String varName) throws UnsupportedFormException {
        throw new UnsupportedFormException();
    }
}
