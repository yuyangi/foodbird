package com.sub.gen.meta.method;

import com.sub.gen.enums.DataType;
import com.sub.gen.enums.MetaType;
import com.sub.gen.enums.MethodType;
import com.sub.gen.meta.IClass;
import com.sub.gen.meta.IType;
import com.sub.gen.meta.type.Type;
import com.sub.gen.tools.CodeBuilder;

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
        setParent(iClass);
        this.parent = iClass;
    }

    @Override
    public String methodBody() {
        return null;
    }

    @Override
    public IType getReturnType() {
        if (returnType == null) {
            returnType = new Type();
            ((Type)returnType).setType(DataType.CLASS);
            ((Type)returnType).setClassType(getParent());
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
