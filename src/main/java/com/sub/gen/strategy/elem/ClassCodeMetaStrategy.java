package com.sub.gen.strategy.elem;

import java.util.ArrayList;
import java.util.List;

import com.sub.gen.meta.ICodeModel;
import com.sub.gen.meta.IParameter;
import com.sub.gen.tools.CodeBuilder;
import com.sub.gen.tools.NameUtils;

/**
 * Created by yy111026 on 2017/2/9.
 */
public class ClassCodeMetaStrategy extends AbstractGenMetaStrategy {

    public ClassCodeMetaStrategy() {
    }

    @Override
    public String stateForm(ICodeModel model) {
        return model.toCode();
    }

    @Override
    public String invokeForm(ICodeModel model, IParameter... parameters) {
        CodeBuilder code = new CodeBuilder();
        String parameterString = "";
        if (parameters != null && parameters.length > 0) {
            List<String> paramList = new ArrayList<>(parameters.length);
            for (IParameter parameter : parameters) {
                paramList.add(parameter.getCode());
            }
            parameterString = String.join(", " + paramList);
        }
        code.append(model.getCode()).append(" " + NameUtils.getVarName(model.getCode())).assign("new " + model.getCode() + "(" + parameterString + ");");
        return code.toString();
    }

    @Override
    public String variableForm(ICodeModel model, String varName) {
        return model.getCode() + " " + varName != null ? varName : NameUtils.getVarName(model.getCode()) + ";";
    }

}
