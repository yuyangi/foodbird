package com.foodbird.generate.java.codes;

import com.foodbird.generate.java.enums.MethodType;

import java.util.List;

public interface IMethod extends ICodeModel {

    IParameter[] getParameters();

    IType getReturnType();

    List<IClass> getImports();

    MethodType getMethodType();

    List<IReference> getReferences();

}
