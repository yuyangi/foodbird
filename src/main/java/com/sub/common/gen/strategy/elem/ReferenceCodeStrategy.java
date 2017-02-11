package com.sub.common.gen.strategy.elem;

import com.sub.common.gen.meta.ICodeModel;
import com.sub.common.gen.meta.IParameter;
import com.sub.common.gen.strategy.ICodeElemStrategy;

/**
 * Created by yy111026 on 2017/2/9.
 */
public class ReferenceCodeStrategy extends AbstractCodeElemStrategy {

    public ReferenceCodeStrategy(ICodeModel model) {
        super(model);
    }

    @Override
    public String stateForm() {
        return null;
    }

    @Override
    public String invokeForm(IParameter... parameters) {
        return null;
    }

    @Override
    public String variableForm(String varName) {
        return null;
    }
}
