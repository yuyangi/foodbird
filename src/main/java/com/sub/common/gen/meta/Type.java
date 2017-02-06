package com.sub.common.gen.meta;

import com.sub.common.gen.enums.DataType;

/**
 * Created by yy111026 on 2017/2/6.
 */
public class Type implements IType {

    private DataType type;

    private IClass classType;

    @Override
    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }

    @Override
    public IClass getClassType() {
        return classType;
    }

    public void setClassType(IClass classType) {
        this.classType = classType;
    }
}
