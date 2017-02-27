package com.sub.gen.meta.classes;

import com.sub.gen.enums.DataType;
import com.sub.gen.enums.MetaType;
import com.sub.gen.meta.BaseCodeModel;
import com.sub.gen.meta.IAttribute;
import com.sub.gen.meta.IClass;
import com.sub.gen.meta.IMethod;

import java.util.List;

/**
 * @author yy111026 on 2017/2/24.
 */
public class Void extends BaseCodeModel implements IClass {

    @Override
    public String toCode() {
        return DataType.VOID.name();
    }

    @Override
    public List<IAttribute> getAttributes() {
        return null;
    }

    @Override
    public List<IMethod> getMethods() {
        return null;
    }

    @Override
    public List<IClass> getGenerics() {
        return null;
    }

    @Override
    public String getQualifiedName() {
        return DataType.VOID.name();
    }

    @Override
    public void setVarName(String varName) {

    }

    @Override
    public String getVarName() {
        return DataType.VOID.name();
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Type;
    }
}
