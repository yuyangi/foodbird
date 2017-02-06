package com.sub.common.gen.meta;

public interface IMethod extends ICodeModel {

    IParameter[] getParameters();

    IType getReturnType();

    IClass getParent();

}
