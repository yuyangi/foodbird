package com.foodbird.generate.java.enums;

public enum Modifier {

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

}
