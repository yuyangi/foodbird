package com.sub.gen.meta;

import com.sub.gen.ICoder;
import com.sub.gen.enums.DataType;

public interface IType extends ICodeModel {

    DataType getType();

    IClass getClassType();

}
