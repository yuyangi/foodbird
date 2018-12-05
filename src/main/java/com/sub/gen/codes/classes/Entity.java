package com.sub.gen.codes.classes;

import com.sub.gen.codes.*;
import com.sub.gen.constants.Constants;
import com.sub.gen.enums.MetaType;
import com.sub.gen.codes.method.Getter;
import com.sub.gen.codes.method.JConstructor;
import com.sub.gen.codes.method.Setter;
import com.sub.gen.codes.type.Type;
import com.sub.gen.tools.CodeBuilder;
import com.sub.gen.tools.NameUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Entity extends BaseCodeModel implements JClass, IType {

    private List<IAttribute> attributes;

    private List<IMethod> methods;

    private List<IClass> generics;

    private List<IMethod> constructors;

    private String varName;

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

    @Override
    public List<IMethod> getConstructors() {
        if (constructors == null) {
            constructors = new ArrayList<>();
            JConstructor constructor = new JConstructor();
            constructor.setParent(this);
            Type returnType = new Type();
            returnType.setType(this);
            constructor.setReturnType(returnType);
            constructors.add(constructor);
        }
        return constructors;
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
    public String getQualifiedName() {
        return getPackages() + "." + getName();
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Class;
    }

    @Override
    public String getVarName() {
        if (varName == null) {
            varName = NameUtils.getVarName(getCode());
        }
        return varName;
    }

    @Override
    public void setVarName(String varName) {
        this.varName = varName;
    }

    @Override
    public IClass getType() {
        return this;
    }

    @Override
    public String toCode() {
        CodeBuilder codes = new CodeBuilder();
        // packages line
        codes.addPackage(String.join(".", getPackages().getPackages())).end();
        codes.append(Constants.LINE_SEPARATOR).newLine();
        // _import
        Set<String> imports = new HashSet<String>();
        boolean hasAttribute = attributes != null;
        if (hasAttribute) {
            hasAttribute = true;
            attributes.stream().filter(attr -> attr.getType().getType() != null).forEach(
                    attr -> imports.add(attr.getType().getType().getPackages().toString() + "." + attr.getType().getType().getCode()));
        }
        imports.forEach(imp -> codes.addImport(imp).end().newLine());
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
