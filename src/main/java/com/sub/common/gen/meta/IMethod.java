package com.sub.common.gen.meta;

import java.util.List;

public interface IMethod extends ICodeModel {

    IParameter[] getParameters();

    IType getReturnType();

    IClass getParent();

    List<IClass> getImports();

}
