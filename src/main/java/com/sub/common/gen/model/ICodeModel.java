package com.sub.common.gen.model;

import com.sub.common.gen.enums.Modifier;

public interface ICodeModel extends ICoder {

	String name();

	String code();

	String level();

	String module();
	
	Modifier visibility();

	Modifier modifier();
	
}
