package com.sub.common.gen.meta.reference;

import com.sub.common.gen.enums.ReferenceType;
import com.sub.common.gen.meta.IClass;
import com.sub.common.gen.meta.IMethod;
import com.sub.common.gen.meta.IReference;

/**
 * Created by yy111026 on 2017/2/9.
 */
public class Reference implements IReference {

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

        return null;
    }
}
