package com.sub.common.gen.meta;

import com.sub.common.gen.enums.MethodType;

import java.util.List;

public interface IMethod extends ICodeModel {

    IParameter[] getParameters();

    IType getReturnType();

    List<IClass> getImports();

    MethodType getMethodType();

}
