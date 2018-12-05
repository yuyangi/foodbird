package com.foodbird.generate.java.codes.classes;

import com.foodbird.generate.java.codes.*;
import com.foodbird.generate.java.constants.Constants;
import com.foodbird.generate.java.enums.MetaType;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/12/5
 */
public abstract class BaseClass extends BaseCodeModel implements JClass, IType, Constants {

    @Override
    public String getQualifiedName() {
        return getPackages() + "." + getName();
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Class;
    }

    @Override
    abstract public String toCode();

    @Override
    public IClass getType() {
        return this;
    }

    protected List<IAttribute> attributes;

    protected List<IMethod> methods;

    protected List<IClass> generics;

    protected List<IMethod> constructors;

    protected String varName;

    @Override
    public List<IAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<IAttribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public List<IMethod> getMethods() {
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
    public List<IMethod> getConstructors() {
        return constructors;
    }

    public void setConstructors(List<IMethod> constructors) {
        this.constructors = constructors;
    }

    @Override
    public String getVarName() {
        return varName;
    }

    @Override
    public void setVarName(String varName) {
        this.varName = varName;
    }
}
