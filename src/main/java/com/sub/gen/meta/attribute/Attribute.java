package com.sub.gen.meta.attribute;

import com.sub.gen.enums.MetaType;
import com.sub.gen.meta.BaseCodeModel;
import com.sub.gen.meta.IAttribute;
import com.sub.gen.meta.IType;
import com.sub.gen.tools.CodeBuilder;
import com.sub.gen.tools.NameUtils;

/**
 * @author yy111026 on 2017/2/6.
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

    @Override
    public MetaType getMetaType() {
        return MetaType.Attribute;
    }
}
