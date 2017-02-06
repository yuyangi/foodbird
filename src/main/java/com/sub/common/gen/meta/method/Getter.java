package com.sub.common.gen.meta.method;

import com.sub.common.gen.constants.IConstants;
import com.sub.common.gen.enums.Modifier;
import com.sub.common.gen.meta.*;
import com.sub.common.gen.meta.BaseCodeModel;
import com.sub.common.gen.tools.Line;
import com.sub.common.gen.tools.Segment;
import org.springframework.stereotype.Component;

/**
 * Created by yuyang on 2016/11/27.
 */
@Component("getter")
public class Getter extends BaseCodeModel implements IMethod, IConstants {

    private IAttribute attribute;

    public Getter() {

    }

    public Getter(IAttribute attribute) {
        super();
        this.attribute = attribute;
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
        new Segment(
                new Line().append(getVisibility()).append(getReturnType().getCode()).
                        append(getter()).bracket("").leftBrace().swapLine(),
                new Line(INDENT)._return().append(attribute.getCode()).stateEnd().swapLine(),
                new Line().rightBrace()
        );
        return null;
    }

    private String getter() {
        return "get" + attribute.getCode().substring(0, 1).toUpperCase() + attribute.getCode().substring(1);
    }

}
