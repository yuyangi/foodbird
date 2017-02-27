package com.sub.gen.meta.method;

import com.sub.gen.constants.Constants;
import com.sub.gen.enums.DataType;
import com.sub.gen.enums.MetaType;
import com.sub.gen.enums.MethodType;
import com.sub.gen.tools.CodeBuilder;
import com.sub.gen.tools.CollectionUtils;
import com.sub.gen.meta.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yy111026 on 2016/12/7.
 */
public abstract class SpringServiceMethod extends BaseCodeModel implements IMethod, Constants {

    private List<IParameter> parameters;

    private IType returnType;

    private List<IClass> exceptions;

    private List<IClass> imports;

    private List<IClass> references;

    @Override
    public IParameter[] getParameters() {
        return parameters.toArray(new IParameter[0]);
    }

    @Override
    public IType getReturnType() {
        return returnType;
    }

    protected String getThrows() {
        if(exceptions != null) {
            return " throw " + String.join(COMMA, CollectionUtils.convert(exceptions, t -> t.getCode()));
        }
        return "";
    }

    protected String getReturn() {
        if(returnType != null) {
            return returnType.getType() != null ? returnType.getType().getCode() : returnType.getType().getCode();
        }
        return "void";
    }

    protected String getParameterString() {
        if(getParameters() != null) {
            CodeBuilder paramBuilder = new CodeBuilder();
            List<String> paramDef = new ArrayList<>();
            for (IParameter param : getParameters()) {
                paramDef.add(param.getType().getType().getCode() + " " + param.getCode());
            }
            paramBuilder.append(String.join(", ", paramDef));
            return paramBuilder.toString();
        }
        return null;
    }

    @Override
    public MethodType getMethodType() {
        return MethodType.Normal;
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Method;
    }

    @Override
    public List<IClass> getImports() {
        return imports;
    }

    public void setParameters(List<IParameter> parameters) {
        this.parameters = parameters;
    }

    public void setReturnType(IType returnType) {
        this.returnType = returnType;
    }

    public List<IClass> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<IClass> exceptions) {
        this.exceptions = exceptions;
    }

    public void setImports(List<IClass> imports) {
        this.imports = imports;
    }

    public List<IClass> getReferences() {
        return references;
    }

    public void setReferences(List<IClass> references) {
        this.references = references;
    }
}
