package com.foodbird.generate.java.enums;

import com.foodbird.generate.java.ICoder;

public enum Modifier implements ICoder {

	FINAL,
	STATIC,
	VOLATILE,
	NATIVE,
	SYNCHRONIZED,
	TRANSIENT,
	PRIVATE,
	PROTECTED,
	PUBLIC,
	ABSTRACT;

	public String toString() {
		return name().toLowerCase();
	}

	@Override
	public String toCode() {
		return name().toLowerCase();
	}

}
