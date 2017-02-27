package com.sub.gen.meta.method;

import com.sub.gen.constants.Constants;
import com.sub.gen.enums.MetaType;
import com.sub.gen.enums.MethodType;
import com.sub.gen.enums.Modifier;
import com.sub.gen.meta.*;
import com.sub.gen.tools.CodeBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yuyang on 2016/11/27.
 */
@Component("getter")
public class Getter extends BaseCodeModel implements IMethod, Constants {

    private IAttribute attribute;

    private MethodType methodType;

    public Getter() {

    }

    public Getter(IAttribute attribute, ICodeModel parent) {
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
    public String toCode() {
        CodeBuilder codes = new CodeBuilder();
        codes.append(indent()).append("/**").newLine();
        codes.append(indent()).append(" * getter for " + attribute.getName()).newLine();
        codes.append(indent()).append(" */").newLine();
        codes.append(indent()).append("public " + getReturnType().getType().getCode() + " " + getter() + "(){").newLine();
        codes.append(indent()).append(INDENT + "return " + attribute.getCode() + ";").newLine();
        codes.append(indent()).append("}").newLine();
        return codes.toString();
    }

    private String getter() {
        return "get" + attribute.getCode().substring(0, 1).toUpperCase() + attribute.getCode().substring(1);
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

    @Override
    public List<IClass> getImports() {
        return null;
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Method;
    }
}
