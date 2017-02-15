package com.sub.gen.meta.reference;

import com.sub.gen.enums.InstanceMode;
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

    private InstanceMode referenceInstanceMode;

    private IMethod method;

    private ReferenceType referenceType;

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
    public InstanceMode getReferenceInstanceMode() {
        return referenceInstanceMode;
    }

    public void setReferenceInstanceMode(InstanceMode referenceInstanceMode) {
        this.referenceInstanceMode = referenceInstanceMode;
    }

    @Override
    public ReferenceType getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(ReferenceType referenceType) {
        this.referenceType = referenceType;
    }

    @Override
    public String toCode() {
    	CodeBuilder code = new CodeBuilder();
        return code.toString();
    }
}
