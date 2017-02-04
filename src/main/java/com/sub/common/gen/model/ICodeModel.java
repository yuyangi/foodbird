package com.sub.common.gen.model;

import com.sub.common.gen.enums.Modifier;

public interface ICodeModel extends ICoder {

	String getName();

	String getCode();

	String getLevel();

	String getModule();
	
	Modifier getVisibility();

	Modifier getModifier();
	
}
