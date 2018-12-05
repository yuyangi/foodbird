package com.foodbird.generate.java.codes.attribute;

import com.foodbird.generate.java.codes.BaseCodeModel;
import com.foodbird.generate.java.codes.IAttribute;
import com.foodbird.generate.java.codes.IType;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.tools.CodeBuilder;
import com.foodbird.generate.java.tools.NameUtils;

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
        codes.append(indent()).append(getVisibility().toString() + " ").append(getType().getTypeClass().getCode()).append(" ").append(NameUtils.getVarName(getCode())).end().newLine();
        return codes.toString();
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Attribute;
    }
}
