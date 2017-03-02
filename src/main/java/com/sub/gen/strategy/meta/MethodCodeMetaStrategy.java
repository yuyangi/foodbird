package com.sub.gen.strategy.meta;

import java.util.ArrayList;
import java.util.List;

import com.sub.gen.exception.UnsupportedFormException;
import com.sub.gen.meta.ICodeModel;
import com.sub.gen.meta.IMethod;
import com.sub.gen.meta.IParameter;
import com.sub.gen.tools.CodeBuilder;
import com.sub.gen.tools.NameUtils;

/**
 * @author yy111026
 * 2017/02/13
 */
public class MethodCodeMetaStrategy extends AbstractGenMetaStrategy {

    public MethodCodeMetaStrategy() {
        super();
    }

    @Override
    public String stateForm(ICodeModel model) {
        CodeBuilder code = new CodeBuilder();
        if (model.getParent() != null) {
            IParameter[] parameters = ((IMethod)model).getParameters();
            code.append(model.getCode() + "(" + getParameters(parameters) + ")");
        }
        return code.toString();
    }

    @Override
    public String invokeForm(ICodeModel model, IParameter... parameters) {
        CodeBuilder code = new CodeBuilder();
        if (model.getParent() != null) {
            code.append(NameUtils.getVarName(model.getParent().getCode()) + "." + model.getCode() + "(" + getParameters(parameters) + ");");
        }
        return code.toString();
    }

    private String getParameters(IParameter... parameters) {
        String parameterString = "";
        if (parameters != null && parameters.length > 0) {
            List<String> paramList = new ArrayList<>(parameters.length);
            for (IParameter parameter : parameters) {
                paramList.add(parameter.getType().getType().getCode() + " " + parameter.getCode());
            }
            parameterString = String.join(", " + paramList);
        }
        return parameterString;
    }

    @Override
    public String variableForm(ICodeModel model, String varName) throws UnsupportedFormException {
        throw new UnsupportedFormException("VARIABLE is unsupported by method!");
    }

}
