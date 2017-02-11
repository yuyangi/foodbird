package com.sub.common.gen.meta;

import com.sub.common.gen.ICoder;
import com.sub.common.gen.enums.Modifier;

public interface ICodeModel extends ICoder {

	String getName();

	String getCode();

	String getLevel();

	String getModule();
	
	Modifier getVisibility();

	Modifier getModifier();

	ICodeModel getParent();

	String getComment();
}
