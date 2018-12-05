package com.sub.gen.codes.type;

import com.sub.gen.enums.MetaType;
import com.sub.gen.codes.BaseCodeModel;
import com.sub.gen.codes.IParameter;
import com.sub.gen.codes.IType;

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
        return null;
    }
}
