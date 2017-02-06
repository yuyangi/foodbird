package com.sub.common.gen.meta.method;

import com.sub.common.gen.constants.IConstants;
import com.sub.common.gen.enums.Modifier;
import com.sub.common.gen.meta.IAttribute;
import com.sub.common.gen.meta.IMethod;
import com.sub.common.gen.meta.IParameter;
import com.sub.common.gen.meta.IType;
import com.sub.common.gen.meta.BaseCodeModel;
import com.sub.common.gen.tools.Line;
import com.sub.common.gen.tools.Segment;
import org.springframework.stereotype.Component;

/**
 * Created by yuyang on 2016/11/27.
 */
@Component("setter")
public class Setter extends BaseCodeModel implements IMethod, IConstants {

    private IAttribute attribute;

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
                        append(setter()).bracket(getReturnType().getCode() + " " + attribute.getCode()).leftBrace().swapLine(),
                new Line(INDENT)._this().dot().append(attribute.getCode()).assign().append(attribute.getCode()).stateEnd().swapLine(),
                new Line().rightBrace()
        ).toString();
        return null;
    }

    private String setter() {
        return "set" + attribute.getCode().substring(0, 1).toUpperCase() + attribute.getCode().substring(1);
    }

}
