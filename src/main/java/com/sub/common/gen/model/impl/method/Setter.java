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
import org.springframework.stereotype.Component;

/**
 * Created by yuyang on 2016/11/27.
 */
@Component("setter")
public class Setter extends BaseCodeModel implements IMethod, IConstants {

    private IAttribute attribute;

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
                new Line().append(visibility()).append(returnType().code()).
                        append(setter()).bracket(returnType().code() + " " + attribute.code()).leftBrace().swapLine(),
                new Line(INDENT)._this().dot().append(attribute.code()).assign().append(attribute.code()).stateEnd().swapLine(),
                new Line().rightBrace()
        ).toString();
        return null;
    }

    private String setter() {
        return "set" + attribute.code().substring(0, 1).toUpperCase() + attribute.code().substring(1);
    }

}
