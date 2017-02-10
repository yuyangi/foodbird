package com.sub.common.gen.meta.method;

import com.sub.common.gen.constants.Constants;
import com.sub.common.gen.enums.DataType;
import com.sub.common.gen.enums.MethodType;
import com.sub.common.gen.meta.*;
import com.sub.common.gen.tools.CodeBuilder;
import com.sub.common.gen.tools.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yy111026 on 2017/2/6.
 */
public abstract class Method extends BaseCodeModel implements IMethod, Constants {

    private IType returnType;

    private IParameter[] parameters;

    private List<IClass> imports;

    private List<IClass> exceptions;

    private MethodType methodType;

    @Override
    public IType getReturnType() {
        return returnType;
    }

    public void setReturnType(IType returnType) {
        this.returnType = returnType;
    }

    @Override
    public IParameter[] getParameters() {
        return parameters;
    }

    public void setParameters(IParameter[] parameters) {
        this.parameters = parameters;
    }

    public List<IClass> getImports() {
        return imports;
    }

    public void setImports(List<IClass> imports) {
        this.imports = imports;
    }

    protected String getThrows() {
        if(exceptions != null) {
            return " throw " + String.join(COMMA, CollectionUtils.convert(exceptions, t -> t.getCode()));
        }
        return "";
    }

    protected String getReturn() {
        if(returnType != null) {
            if(Arrays.asList(DataType.Basics).contains(returnType.getType())) {
                return returnType.getType().name().toLowerCase();
            } else if(Arrays.asList(DataType.Objects).contains(returnType.getType())) {
                return returnType.getClassType() != null ? returnType.getClassType().getCode() : returnType.getClassType().getCode();
            }
        }
        return "void";
    }

    protected String getParameterString() {
        if(getParameters() != null) {
            CodeBuilder paramBuilder = new CodeBuilder();
            List<String> paramDef = new ArrayList<>();
            for (IParameter param : getParameters()) {
                paramDef.add(param.getType().getClassType().getCode() + " " + param.getCode());
            }
            paramBuilder.append(String.join(", ", paramDef));
            return paramBuilder.toString();
        }
        return null;
    }

    @Override
    public String toCode() {
        CodeBuilder codeBuilder = new CodeBuilder(indent());
        codeBuilder.append("public " + getReturn() + " "+ getCode() + "(" + getParameterString() + ") " + getThrows() + " {").newLine();
        codeBuilder.append(methodBody()).newLine();
        codeBuilder.append("}").newLine();
        return codeBuilder.toString();
    }

    public List<IClass> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<IClass> exceptions) {
        this.exceptions = exceptions;
    }

    @Override
    public MethodType getMethodType() {
        return methodType;
    }

    public void setMethodType(MethodType methodType) {
        this.methodType = methodType;
    }

    public abstract String methodBody();

}
