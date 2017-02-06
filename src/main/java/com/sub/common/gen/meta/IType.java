package com.sub.common.gen.meta;

import com.sub.common.gen.enums.Type;

public interface IType extends ICodeModel {

    Type getType();

    IClass getClassType();

}
