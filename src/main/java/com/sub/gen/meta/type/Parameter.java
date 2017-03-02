package com.sub.gen.meta.type;

import com.sub.gen.enums.MetaType;
import com.sub.gen.meta.BaseCodeModel;
import com.sub.gen.meta.IParameter;
import com.sub.gen.meta.IType;

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
