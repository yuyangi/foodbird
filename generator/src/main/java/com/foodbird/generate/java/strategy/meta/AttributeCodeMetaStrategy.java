package com.foodbird.generate.java.strategy.meta;

import com.foodbird.generate.java.codes.ICodeModel;
import com.foodbird.generate.java.codes.IParameter;
import com.foodbird.generate.java.exception.UnsupportedFormException;
import com.foodbird.generate.java.tools.CodeBuilder;
import com.foodbird.generate.java.tools.NameUtils;

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
