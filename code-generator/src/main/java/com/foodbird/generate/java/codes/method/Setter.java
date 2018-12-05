package com.foodbird.generate.java.codes.method;

import com.foodbird.generate.java.codes.*;
import com.foodbird.generate.java.constants.Constants;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.enums.MethodType;
import com.foodbird.generate.java.enums.Modifier;
import com.foodbird.generate.java.tools.CodeBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yuyang on 2016/11/27.
 */
@Component("setter")
public class Setter extends BaseCodeModel implements IMethod, Constants {

    private IAttribute attribute;

    private MethodType methodType;

    private List<IReference> references;

    public Setter() {

    }

    public Setter(IAttribute attribute, ICodeModel parent) {
        super();
        this.attribute = attribute;
        this.setParent(parent);
    }

    @Override
    public IParameter[] getParameters() {
        return new IParameter[0];
    }

    @Override
    public IType getReturnType() {
        return attribute.getType();
    }

    @Override
    public Modifier getVisibility() {
        return Modifier.PUBLIC;
    }

    @Override
    public Modifier getModifier() {
        return null;
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Method;
    }

    @Override
    public List<IReference> getReferences() {
        return references;
    }

    public void setReferences(List<IReference> references) {
        this.references = references;
    }

    @Override
    public String toCode() {
        CodeBuilder codes = new CodeBuilder();
        codes.append(indent()).append("public void " + setter() + "("+getReturnType().getTypeClass().getCode() + " " + attribute.getCode()+"){").newLine();
        codes.append(indent()).append(INDENT + "this." + attribute.getCode() + " = " + attribute.getCode() + ";").newLine();
        codes.append(indent()).append("}").newLine();
        return codes.toString();
    }

    private String setter() {
        return "set" + attribute.getCode().substring(0, 1).toUpperCase() + attribute.getCode().substring(1);
    }

    @Override
    public List<IClass> getImports() {
        return null;
    }

    public IAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(IAttribute attribute) {
        this.attribute = attribute;
    }

    @Override
    public MethodType getMethodType() {
        return methodType;
    }

    public void setMethodType(MethodType methodType) {
        this.methodType = methodType;
    }
}
