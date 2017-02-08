package com.sub.common.gen.meta.type;

import com.sub.common.gen.meta.BaseCodeModel;
import com.sub.common.gen.meta.IParameter;
import com.sub.common.gen.meta.IType;

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
    public String toCode() {
        return null;
    }
}
