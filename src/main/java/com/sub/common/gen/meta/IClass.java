package com.sub.common.gen.meta;

import java.util.List;

public interface IClass extends ICodeModel {

	List<IAttribute> getAttributes();

	List<IMethod> getMethods();

	IPackage getPackages();

	List<IClass> getGenerics();

}
