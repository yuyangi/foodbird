package com.sub.common.gen.strategy.elem;

import com.sub.common.gen.meta.IClass;
import com.sub.common.gen.meta.ICodeModel;
import com.sub.common.gen.meta.IParameter;
import com.sub.common.gen.tools.CodeBuilder;
import com.sub.common.gen.tools.NameUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yy111026 on 2017/2/9.
 */
public class ClassCodeStrategy extends AbstractCodeElemStrategy {

    public ClassCodeStrategy(IClass model) {
        super(model);
    }

    @Override
    public String stateForm() {
        return null;
    }

    @Override
    public String invokeForm(IParameter... parameters) {
        CodeBuilder code = new CodeBuilder();
        String parameterString = "";
        if (parameters != null && parameters.length > 0) {
            List<String> paramList = new ArrayList<>(parameters.length);
            for (IParameter parameter : parameters) {
                paramList.add(parameter.getCode());
            }
            parameterString = String.join(", " + paramList);
        }
        code.append(getModel().getCode()).append(" " + NameUtils.getVarName(getModel().getCode())).assign("new " + getModel().getCode() + "(" + parameterString + ");");
        return code.toString();
    }

    @Override
    public String variableForm(String varName) {
        return null;
    }

}
