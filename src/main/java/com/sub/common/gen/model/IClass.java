package com.sub.common.gen.model;

import com.sub.common.gen.enums.Type;

import java.util.List;

public interface IClass extends ICodeModel {

	List<IAttribute> attributes();

	List<IMethod> methods();

	IPackage packages();

	List<IClass> generics();

}
