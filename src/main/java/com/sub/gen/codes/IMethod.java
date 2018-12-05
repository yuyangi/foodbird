package com.sub.gen.codes;

import com.sub.gen.enums.MethodType;

import java.util.List;

public interface IMethod extends ICodeModel {

    IParameter[] getParameters();

    IType getReturnType();

    List<IClass> getImports();

    MethodType getMethodType();

    List<IReference> getReferences();

}
