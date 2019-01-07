package com.foodbird.generate.java.codes.type;

import com.foodbird.generate.java.codes.BaseCodeModel;
import com.foodbird.generate.java.codes.IParameter;
import com.foodbird.generate.java.codes.IType;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.tools.NameUtils;

/**
 * Created by yy111026 on 2017/2/6.
 */
public class Parameter extends BaseCodeModel implements IParameter {

    private IType type;

    @Override
    public IType getType() {
        return type;
    }

    public void setType(IType type) {
        this.type = type;
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Parameter;
    }

    @Override
    public String toCode() {
        return type.getTypeClass().getCode() + " " +
                (getCode() == null
                        ? NameUtils.getVarName(type.getTypeClass().getCode())
                        : getCode());
    }
}
