package com.sub.gen.meta.type;

import com.sub.gen.enums.DataType;
import com.sub.gen.enums.MetaType;
import com.sub.gen.meta.BaseCodeModel;
import com.sub.gen.meta.IClass;
import com.sub.gen.meta.IType;

/**
 * Created by yy111026 on 2017/2/6.
 */
public class Type extends BaseCodeModel implements IType {

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

    @Override
    public String toCode() {
        return null;
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Type;
    }
}
