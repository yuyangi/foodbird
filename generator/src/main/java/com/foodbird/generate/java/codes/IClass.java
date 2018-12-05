package com.foodbird.generate.java.codes;

import java.util.List;

public interface IClass extends ICodeModel {

	List<IAttribute> getAttributes();

	List<IMethod> getMethods();

	IPackage getPackages();

	List<IClass> getGenerics();

	String getQualifiedName();

	void setVarName(String varName);

	String getVarName();

}
