package com.foodbird.generate.java.codes.classes;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.codes.*;
import com.foodbird.generate.java.common.*;
import com.foodbird.generate.java.constants.Constants;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.enums.Modifier;
import com.foodbird.generate.java.enums.ObjectType;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/12/5
 */
public abstract class BaseClass extends BaseCodeModel implements JClass, IType, Constants {

    public BaseClass() {
        super();
        this.setVisibility(Modifier.PUBLIC);
        this.setObjectType(ObjectType.CLASS);
    }

    @Override
    public String getQualifiedName() {
        return getPackages() + "." + getCode();
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Class;
    }

    @Override
    public String toCode() {
        return Section.create(LINE_SEPARATOR+LINE_SEPARATOR, packages(), imports(), Sentence.sentence(classDefine(), body())).toCode();
    }

    private Section packages() {
        return Sentence.sentence(getPackages()).end();
    }

    Section attributes() {
        return IndentSection.create(LINE_SEPARATOR, attributes.stream().map(Sentence::sentence).toArray(ICoder[]::new));
    }

    Section methods() {
        return IndentSection.create(LINE_SEPARATOR, methods.stream().map(IndentSection::create).toArray(ICoder[]::new));
    }

    Section imports() {
        Set<IClass> imports = Sets.newHashSet();
        getAttributes().forEach(attr -> imports.add(attr.getType().getTypeClass()));
        getMethods().forEach(method -> imports.addAll(method.getImports()));
        return Imports.imports(imports.toArray(new IClass[0]));
    }

    Section body() {
        return Body.classBody(attributes(), methods());
    }

    Section classDefine() {
        return Sentence.sentence(getVisibility(), getModifier(), getObjectType(),
                Word.create(getCode()));
    }

    @Override
    public IClass getTypeClass() {
        return this;
    }

    List<IAttribute> attributes;

    List<IMethod> methods;

    List<IClass> generics;

    List<IMethod> constructors;

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
