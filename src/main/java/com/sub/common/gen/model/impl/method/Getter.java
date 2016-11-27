package com.sub.common.gen.model.impl.method;

import com.sub.common.gen.constants.IConstants;
import com.sub.common.gen.enums.Modifier;
import com.sub.common.gen.model.IAttribute;
import com.sub.common.gen.model.IMethod;
import com.sub.common.gen.model.IParameter;
import com.sub.common.gen.model.IType;
import com.sub.common.gen.model.impl.BaseCodeModel;
import com.sub.common.gen.tools.Line;
import com.sub.common.gen.tools.Segment;

/**
 * Created by yuyang on 2016/11/27.
 */
public class Getter extends BaseCodeModel implements IMethod, IConstants {

    private IAttribute attribute;

    public Getter(IAttribute attribute) {
        super();
        this.attribute = attribute;
    }

    @Override
    public IParameter[] parameters() {
        return new IParameter[0];
    }

    @Override
    public IType returnType() {
        return attribute.type();
    }

    @Override
    public Modifier visibility() {
        return Modifier.PUBLIC;
    }

    @Override
    public Modifier modifier() {
        return null;
    }

    @Override
    public String toCode() {
        new Segment(
                new Line().append(visibility().name()).wordSeparator().append(returnType().code()).wordSeparator().
                        append(getter()).leftBracket().append(attribute.type().code()).leftBrace(),
                new Line(INDENT).append(visibility().name()).wordSeparator().append(returnType().code()),
                new Line().append(visibility().name()).wordSeparator().append(returnType().code())
        );
        return null;
    }

    private String getter() {
        return "get" + attribute.code().substring(0, 1).toUpperCase() + attribute.code().substring(1);
    }
}
