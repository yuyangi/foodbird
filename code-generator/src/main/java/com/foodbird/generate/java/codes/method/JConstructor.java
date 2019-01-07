package com.foodbird.generate.java.codes.method;

import com.foodbird.generate.java.codes.IClass;
import com.foodbird.generate.java.codes.IType;
import com.foodbird.generate.java.codes.type.Type;
import com.foodbird.generate.java.common.Body;
import com.foodbird.generate.java.common.Word;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.enums.MethodType;
import com.foodbird.generate.java.tools.CodeBuilder;

/**
 * Created by yy111026 on 2017/2/14.
 */
public class JConstructor extends Method {

    private IType returnType;

    private IClass parent;

    public JConstructor() {
        super();
    }

    public JConstructor(IClass iClass) {
        super();
        this.parent = iClass;
    }

    @Override
    public Body methodBody() {
        return null;
    }

    @Override
    public Word methodName() {
        return Word.create(returnType.getTypeClass().getCode());
    }

    @Override
    public IType getReturnType() {
        if (returnType == null) {
            returnType = new Type();
            ((Type)returnType).setType(getParent());
        }
        return returnType;
    }

    public IClass getParent() {
        return this.parent;
    }

    public void setParent(IClass parent) {
        this.parent = parent;
    }

    @Override
    public MethodType getMethodType() {
        return MethodType.Constructor;
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Method;
    }

    public String toCode() {
        CodeBuilder code = new CodeBuilder();
        code.append(getModifier().toString()).append(" ").append(getCode()).append("() {").newLine();
        code.append("}").newLine();

        return code.toString();
    }

}
