package com.sub.common.gen.model;

import com.sub.common.gen.enums.Type;

import java.util.List;

public interface IClass extends ICodeModel {

	List<IAttribute> getAttributes();

	List<IMethod> getMethods();

	IPackage getPackages();

	List<IClass> getGenerics();

	IClass getParent();

}
