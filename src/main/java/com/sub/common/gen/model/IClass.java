package com.sub.common.gen.model;

import java.util.List;

public interface IClass extends ICodeModel {

	List<IAttribute> attributes();

	List<IMethod> methods();

	IPackage packages();



}
