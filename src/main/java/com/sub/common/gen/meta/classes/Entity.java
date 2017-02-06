package com.sub.common.gen.meta.classes;

import java.util.ArrayList;
import java.util.List;

import com.sub.common.gen.meta.IAttribute;
import com.sub.common.gen.meta.IClass;
import com.sub.common.gen.meta.IMethod;
import com.sub.common.gen.meta.BaseCodeModel;

public class Entity extends BaseCodeModel implements IClass {

	private List<IAttribute> attributes;
	
	private List<IMethod> methods;

	private List<IClass> generics;

	public List<IAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<IAttribute> attributes) {
		this.attributes = attributes;
	}

	public List<IMethod> getMethods() {
        if(attributes != null) {
            List<IMethod> methods = new ArrayList<>();
            attributes.forEach(attr -> methods.addAll(getterSetters(attr)));
        }
		return methods;
	}

    private List<IMethod> getterSetters(IAttribute attr) {
        if(attr != null) {

        }
        return null;
    }

    public void setMethods(List<IMethod> methods) {
		this.methods = methods;
	}

	@Override
	public List<IClass> getGenerics() {
		return generics;
	}

	public void setGenerics(List<IClass> generics) {
		this.generics = generics;
	}

	@Override
	public String toCode() {
		return null;
	}
}
