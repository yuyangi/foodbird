package com.sub.common.gen.model.impl.classes;

import java.util.ArrayList;
import java.util.List;

import com.sub.common.gen.model.IAttribute;
import com.sub.common.gen.model.IClass;
import com.sub.common.gen.model.IMethod;
import com.sub.common.gen.model.impl.BaseCodeModel;

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

	public List<IAttribute> attributes() {
		return attributes;
	}

	public List<IMethod> methods() {
		return methods;
	}

	public String toCode() {

		return null;
	}

	@Override
	public List<IClass> generics() {
		return generics;
	}
}
