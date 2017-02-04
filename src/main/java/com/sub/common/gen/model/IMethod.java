package com.sub.common.gen.model;

public interface IMethod extends ICodeModel {

    IParameter[] getParameters();

    IType getReturnType();

    IClass getParent();

}
