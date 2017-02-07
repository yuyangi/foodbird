package com.sub.common.gen.meta;

import java.util.List;

public interface IMethod extends ICodeModel {

    IParameter[] getParameters();

    IType getReturnType();

    List<IClass> getImports();

}
