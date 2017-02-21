package com.sub.gen.meta;

import com.sub.gen.ICoder;
import com.sub.gen.enums.MetaType;
import com.sub.gen.enums.Modifier;

public interface ICodeModel extends ICoder {

	String getName();

	String getCode();

	String getLevel();

	String getModule();
	
	Modifier getVisibility();

	Modifier getModifier();

	ICodeModel getParent();

	String getComment();

	MetaType getMetaType();
}
