package com.sub.common.gen.meta.method;

import com.sub.common.gen.constants.Constants;
import com.sub.common.gen.enums.Modifier;
import com.sub.common.gen.meta.*;
import com.sub.common.gen.tools.CodeBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yuyang on 2016/11/27.
 */
@Component("getter")
public class Getter extends BaseCodeModel implements IMethod, Constants {

    private IAttribute attribute;

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
        codes.append(indent()).append("public " + getReturnType().getClassType().getCode() + " " + getter() + "(){").newLine();
        codes.append(indent()).append(INDENT + "return " + attribute.getCode() + ";").newLine();
        codes.append(indent()).append("}").newLine();
        return codes.toString();
    }

    private String getter() {
        return "get" + attribute.getCode().substring(0, 1).toUpperCase() + attribute.getCode().substring(1);
    }

    @Override
    public List<IClass> getImports() {
        return null;
    }
}
