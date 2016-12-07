package com.sub.common.gen.enums;

public enum Elements {

	CLASS(Modifier.PUBLIC, Modifier.ABSTRACT, Modifier.FINAL),
	METHOD(Modifier.PUBLIC, Modifier.PROTECTED, Modifier.PRIVATE, Modifier.ABSTRACT, Modifier.FINAL, Modifier.STATIC, Modifier.NATIVE, Modifier.SYNCHRONIZED),
	CONSTRUCTOR(Modifier.PUBLIC, Modifier.PROTECTED, Modifier.PRIVATE),
	MEMBER_FIELD(Modifier.PUBLIC, Modifier.PROTECTED, Modifier.PRIVATE, Modifier.STATIC, Modifier.TRANSIENT, Modifier.VOLATILE, Modifier.FINAL),
	LOCAL_FIELD(Modifier.FINAL);
	
	Elements(Modifier... modifiers) {
		this.modifiers = modifiers;
	}
	
	private Modifier[] modifiers;
	
	public boolean accessable(Modifier modifier) {
		if(this.modifiers != null) {
			for(Modifier m : this.modifiers) {
				if(m == modifier) {
					return true;
				}
			}
		}
		return false;
	}
	
}
