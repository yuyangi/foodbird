package com.sub.gen.strategy.elem;

import com.sub.gen.meta.ICodeModel;
import com.sub.gen.meta.IParameter;

/**
 * @author  yy111026
 * 2017/2/9.
 */
public class ReferenceCodeMetaStrategy extends AbstractGenMetaStrategy {

    public ReferenceCodeMetaStrategy() {

    }

    @Override
    public String defineForm(ICodeModel model) {
        return model.toCode();
    }

    @Override
    public String stateForm(ICodeModel model) {
        return null;
    }

    @Override
    public String invokeForm(ICodeModel model, IParameter... parameters) {
        return null;
    }

    @Override
    public String variableForm(ICodeModel model, String varName) {
        return null;
    }
}
