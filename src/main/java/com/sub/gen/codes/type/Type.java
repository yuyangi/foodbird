package com.sub.gen.codes.type;

import com.sub.gen.enums.MetaType;
import com.sub.gen.codes.BaseCodeModel;
import com.sub.gen.codes.IClass;
import com.sub.gen.codes.IType;

/**
 * Created by yy111026 on 2017/2/6.
 */
public class Type extends BaseCodeModel implements IType {

    private IClass type;

    @Override
    public IClass getType() {
        return type;
    }

    public void setType(IClass type) {
        this.type = type;
    }

    @Override
    public String toCode() {
        return null;
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Type;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Type)) {
            return false;
        }
        Type otherType = (Type)other;
        if (getType() != otherType.getType()) {
            return false;
        }
        if (getType().getCode().equals(otherType.getCode()) &&
                getType().getPackages().toString().equals(otherType.getType().getPackages().toString())) {
            return true;
        }
        return false;
    }

}
