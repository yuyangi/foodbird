package com.sub.common.gen.meta.method;

import com.sub.common.gen.constants.Constants;
import com.sub.common.gen.enums.Modifier;
import com.sub.common.gen.meta.*;
import com.sub.common.gen.tools.CodeBuilder;
import com.sub.common.gen.tools.Line;
import com.sub.common.gen.tools.Segment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yuyang on 2016/11/27.
 */
@Component("setter")
public class Setter extends BaseCodeModel implements IMethod, Constants {

    private IAttribute attribute;

    public Setter() {

    }

    public Setter(IAttribute attribute) {
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
        CodeBuilder codes = new CodeBuilder();

        return new Segment(INDENT,
                new Line().append(getVisibility()).append(getReturnType().getClassType().getCode()).
                        append(setter()).bracket(getReturnType().getClassType().getCode() + " " + attribute.getCode()).leftBrace().swapLine(),
                new Line(INDENT)._this().dot().append(attribute.getCode()).assign().append(attribute.getCode()).stateEnd().swapLine(),
                new Line().rightBrace()
        ).toString();
    }

    private String setter() {
        return "set" + attribute.getCode().substring(0, 1).toUpperCase() + attribute.getCode().substring(1);
    }

    @Override
    public List<IClass> getImports() {
        return null;
    }
}
