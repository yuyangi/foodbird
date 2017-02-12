package com.sub.common.gen.strategy.elem;

import com.sub.common.gen.exception.UnsupportedFormException;
import com.sub.common.gen.meta.IAttribute;
import com.sub.common.gen.meta.IParameter;
import com.sub.common.gen.tools.CodeBuilder;
import com.sub.common.gen.tools.NameUtils;

/**
 * Created by yy111026 on 2017/2/9.
 */
public class AttributeCodeStrategy extends AbstractCodeElemStrategy {

    public AttributeCodeStrategy(IAttribute model) {
        super(model);
    }

    @Override
    public String stateForm() throws UnsupportedFormException {
        return getModel().getCode() + ";";
    }

    @Override
    public String invokeForm(IParameter... parameters) throws UnsupportedFormException {
        CodeBuilder code = new CodeBuilder();
        if (getModel().getParent() != null) {
            code.append(NameUtils.getVarName(getModel().getParent().getCode()) + "." + getModel().getCode() + ";");
        }
        return code.toString();
    }

    @Override
    public String variableForm(String varName) throws UnsupportedFormException {
        throw new UnsupportedFormException("VARIABLE is unsupported by attribute!");
    }
}
