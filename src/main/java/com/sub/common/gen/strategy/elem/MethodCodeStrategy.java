package com.sub.common.gen.strategy.elem;

import java.util.ArrayList;
import java.util.List;

import com.sub.common.gen.exception.UnsupportedFormException;
import com.sub.common.gen.meta.IMethod;
import com.sub.common.gen.meta.IParameter;
import com.sub.common.gen.tools.CodeBuilder;
import com.sub.common.gen.tools.NameUtils;

/**
 * Created by yy111026 on 2017/2/9.
 */
public class MethodCodeStrategy extends AbstractCodeElemStrategy {

    public MethodCodeStrategy(IMethod model) {
        super(model);
    }

    @Override
    public String stateForm() {
        CodeBuilder code = new CodeBuilder();
        if (getModel().getParent() != null) {
            IParameter[] parameters = ((IMethod)getModel()).getParameters();
            code.append(getModel().getCode() + "(" + getParameters(parameters) + ")");
        }
        return code.toString();
    }

    @Override
    public String invokeForm(IParameter... parameters) {
        CodeBuilder code = new CodeBuilder();
        if (getModel().getParent() != null) {
            code.append(NameUtils.getVarName(getModel().getParent().getCode()) + "." + getModel().getCode() + "(" + getParameters(parameters) + ");");
        }
        return code.toString();
    }

    private String getParameters(IParameter... parameters) {
        String parameterString = "";
        if (parameters != null && parameters.length > 0) {
            List<String> paramList = new ArrayList<>(parameters.length);
            for (IParameter parameter : parameters) {
                paramList.add(parameter.getType().getClassType().getCode() + " " + parameter.getCode());
            }
            parameterString = String.join(", " + paramList);
        }
        return parameterString;
    }

    @Override
    public String variableForm(String varName) throws UnsupportedFormException {
        throw new UnsupportedFormException("VARIABLE is unsupported by method!");
    }

}
