package com.foodbird.generate.java.codes.type;

import com.foodbird.generate.java.codes.BaseCodeModel;
import com.foodbird.generate.java.codes.IClass;
import com.foodbird.generate.java.codes.IType;
import com.foodbird.generate.java.codes.classes.ClassAdapter;
import com.foodbird.generate.java.codes.classes.Void;
import com.foodbird.generate.java.enums.MetaType;

/**
 * Created by yy111026 on 2017/2/6.
 */
public class Type extends BaseCodeModel implements IType {

    public static Type typeVoid = new Type(new Void());

    private IClass type;

    public Type() {
    }

    public Type(IClass type) {
        this.type = type;
    }

    @Override
    public IClass getTypeClass() {
        return type;
    }

    public void setType(IClass type) {
        this.type = type;
    }

    @Override
    public String toCode() {
        return type.getCode();
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
        if (this.getTypeClass() != this.getTypeClass()) {
            return false;
        }
        if (this.getTypeClass().getCode().equals(otherType.getCode()) &&
                this.getTypeClass().getPackages().toString().equals(this.getTypeClass().getPackages().toString())) {
            return true;
        }
        return false;
    }

    public static IType typeOf(IClass type) {
        return new Type(type);
    }

    public static IType typeOf(Class<?> type) {
        return new Type(new ClassAdapter(type));
    }

    public static IType typeVoid() {
        return typeVoid;
    }

}
