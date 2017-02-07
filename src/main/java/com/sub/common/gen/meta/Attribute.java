package com.sub.common.gen.meta;

import com.sub.common.gen.tools.CodeBuilder;
import com.sub.common.gen.tools.NameUtils;

/**
 * Created by yy111026 on 2017/2/6.
 */
public class Attribute extends BaseCodeModel implements IAttribute {

    private IType type;

    @Override
    public IType getType() {
        return type;
    }

    public void setType(IType type) {
        this.type = type;
    }

    @Override
    public String toCode() {
        CodeBuilder codes = new CodeBuilder();
        codes.append(indent()).append("/**").newLine();
        codes.append(indent()).append(" * " + getName()).newLine();
        codes.append(indent()).append(" */").newLine();
        codes.append(indent()).append(getVisibility().toString() + " ").append(getType().getClassType().getCode()).append(" ").append(NameUtils.getVarName(getCode())).end().newLine();
        return codes.toString();
    }

}
