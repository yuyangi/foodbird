package com.sub.gen.strategy.meta;

import com.sub.gen.enums.MetaType;
import com.sub.gen.exception.UnsupportedFormException;
import com.sub.gen.meta.ICodeModel;
import com.sub.gen.meta.IParameter;
import com.sub.gen.tools.CodeBuilder;
import com.sub.gen.tools.NameUtils;

/**
 * @author yy111026 on 2017/2/9.
 */
public class AttributeCodeMetaStrategy extends AbstractGenMetaStrategy {

    public AttributeCodeMetaStrategy() {
        super();
    }

    @Override
    public String stateForm(ICodeModel model) throws UnsupportedFormException {
        return model.getCode() + ";";
    }

    @Override
    public String invokeForm(ICodeModel model, IParameter... parameters) throws UnsupportedFormException {
        CodeBuilder code = new CodeBuilder();
        if (model.getParent() != null) {
            code.append(NameUtils.getVarName(model.getParent().getCode()) + "." + model.getCode() + ";");
        }
        return code.toString();
    }

    @Override
    public String variableForm(ICodeModel model, String varName) throws UnsupportedFormException {
        throw new UnsupportedFormException("VARIABLE is unsupported by attribute!");
    }
}
