package com.foodbird.generate.java.codes.classes;

import com.foodbird.generate.java.codes.BaseCodeModel;
import com.foodbird.generate.java.codes.IAttribute;
import com.foodbird.generate.java.codes.IClass;
import com.foodbird.generate.java.codes.IMethod;
import com.foodbird.generate.java.enums.DataType;
import com.foodbird.generate.java.enums.MetaType;

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
