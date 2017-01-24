package com.sub.common.gen.model;

public interface IMethod extends ICodeModel {

    IParameter[] parameters();

    IType returnType();

    IClass parent();

}
