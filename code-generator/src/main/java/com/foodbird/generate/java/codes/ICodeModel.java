package com.foodbird.generate.java.codes;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.enums.Modifier;

public interface ICodeModel extends ICoder, Identity {

	String getName();

	String getCode();

	String getLevel();

	String getModule();
	
	Modifier getVisibility();

	Modifier getModifier();

	ICodeModel getParent();

	String getComment();

	MetaType getMetaType();

    boolean equals(Object other);
}
