package com.foodbird.generate.java.codes;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.enums.Modifier;
import com.foodbird.generate.java.enums.ObjectType;

public interface ICodeModel extends ICoder, Identity {

	String getName();

	String getCode();

	String getLevel();

	String getModule();
	
	Modifier getVisibility();

	Modifier getModifier();

	ObjectType getObjectType();

	ICodeModel getParent();

	String getComment();

	MetaType getMetaType();

    boolean equals(Object other);
}
