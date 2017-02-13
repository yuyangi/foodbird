package com.sub.gen.strategy.elem;

import com.sub.gen.exception.UnsupportedFormException;
import com.sub.gen.meta.ICodeModel;
import com.sub.gen.meta.IParameter;

/**
 * Created by yy111026 on 2017/2/13.
 *
 * @author yy111026
 * @date 2017/02/13
 */
public class DefaultCodeStrategy extends AbstractCodeElemStrategy {

    public DefaultCodeStrategy() {

    }

    @Override
    public String defineForm(ICodeModel model) {
        return model.getCode();
    }

    @Override
    public String stateForm(ICodeModel model) throws UnsupportedFormException {
        return model.toString();
    }

    @Override
    public String invokeForm(ICodeModel model, IParameter... parameters) throws UnsupportedFormException {
        return model.getCode();
    }

    @Override
    public String variableForm(ICodeModel model, String varName) throws UnsupportedFormException {
        return model.toCode();
    }
}
