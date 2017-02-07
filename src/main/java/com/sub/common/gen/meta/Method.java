package com.sub.common.gen.meta;

import com.sub.common.gen.tools.CodeBuilder;

import java.util.List;

/**
 * Created by yy111026 on 2017/2/6.
 */
public abstract class Method extends BaseCodeModel implements IMethod {

    private IType returnType;

    private IParameter[] parameters;

    private List<IClass> imports;

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

}
