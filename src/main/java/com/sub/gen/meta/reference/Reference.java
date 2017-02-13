package com.sub.gen.meta.reference;

import com.sub.gen.enums.ReferenceType;
import com.sub.gen.meta.BaseCodeModel;
import com.sub.gen.meta.IClass;
import com.sub.gen.meta.IMethod;
import com.sub.gen.meta.IReference;
import com.sub.gen.tools.CodeBuilder;

/**
 * @author yy111026
 * @date 2017/02/13
 */
public class Reference extends BaseCodeModel implements IReference {

    private IClass reference;

    private IMethod method;

    private ReferenceType refType;

    @Override
    public IClass getReference() {
        return reference;
    }

    public void setReference(IClass reference) {
        this.reference = reference;
    }

    @Override
    public IMethod getMethod() {
        return method;
    }

    public void setMethod(IMethod method) {
        this.method = method;
    }

    @Override
    public ReferenceType getRefType() {
        return refType;
    }

    public void setRefType(ReferenceType refType) {
        this.refType = refType;
    }

    @Override
    public String toCode() {
    	CodeBuilder code = new CodeBuilder();
    	code.append(model)
        return code.toString();
    }
}
