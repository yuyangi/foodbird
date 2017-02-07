package com.sub.common.gen.meta.classes;

import com.sub.common.gen.constants.Constants;
import com.sub.common.gen.meta.BaseCodeModel;
import com.sub.common.gen.meta.IAttribute;
import com.sub.common.gen.meta.IClass;
import com.sub.common.gen.meta.IMethod;
import com.sub.common.gen.meta.method.Getter;
import com.sub.common.gen.meta.method.Setter;
import com.sub.common.gen.tools.CodeBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (methods == null) {
            methods = new ArrayList<>();
            if (attributes != null) {
                attributes.forEach(a ->
                {
                    methods.add(new Getter(a, this));
                    methods.add(new Setter(a, this));
                });
            }
        }
        return methods;
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
        CodeBuilder codes = new CodeBuilder();
        // package line
        codes._package(String.join(".", getPackages().getPackages())).end();
        codes.append(Constants.LINE_SEPARATOR).newLine();
        // _import
        Set<String> imports = new HashSet<String>();
        boolean hasAttribute = attributes != null;
        if (hasAttribute) {
            hasAttribute = true;
            attributes.stream().filter(attr -> attr.getType().getClassType() != null).forEach(
                    attr -> imports.add(attr.getType().getClassType().getPackages().toString() + "." + attr.getType().getClassType().getCode()));
        }
        imports.forEach(imp -> codes._import(imp).end().newLine());
        // class body
        codes.newLine();
        // attributes
        codes._public("class ").append(getCode() + " {").newLine().newLine();
        if (hasAttribute) {
            attributes.forEach(attr -> codes.append(attr.toCode()).newLine());
        }
        // methods
        getMethods().forEach(method -> codes.append(method.toCode()).newLine());
        codes.append("}").append(Constants.LINE_SEPARATOR);
        return codes.toString();
    }
}
