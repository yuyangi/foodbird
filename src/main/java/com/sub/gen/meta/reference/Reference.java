package com.sub.gen.meta.reference;

import com.sub.gen.enums.InstanceMode;
import com.sub.gen.enums.MetaType;
import com.sub.gen.enums.ReferenceForm;
import com.sub.gen.enums.ReferenceType;
import com.sub.gen.exception.UnsupportedFormException;
import com.sub.gen.meta.BaseCodeModel;
import com.sub.gen.meta.IClass;
import com.sub.gen.meta.IMethod;
import com.sub.gen.meta.IReference;
import com.sub.gen.strategy.IGenFormStrategy;
import com.sub.gen.strategy.factory.DefaultGenFormStrategyFactory;
import com.sub.gen.strategy.factory.IGenFormStrategyFactory;
import com.sub.gen.strategy.form.DefaultFormStrategy;
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

    private ReferenceForm referenceForm;

    private IGenFormStrategyFactory factory = DefaultGenFormStrategyFactory.getInstance();

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
    public MetaType getMetaType() {
        return MetaType.Reference;
    }

    @Override
    public ReferenceForm getReferenceForm() {
        return referenceForm;
    }

    public void setReferenceForm(ReferenceForm referenceForm) {
        this.referenceForm = referenceForm;
    }

    private IGenFormStrategy getStrategy() {
        IGenFormStrategy strategy = factory.create(getReferenceForm());
        if (strategy == null) {
            strategy = new DefaultFormStrategy();
        }
        return strategy;
    }

    @Override
    public String toCode() {
        CodeBuilder code = new CodeBuilder();
        try {
            switch (referenceType) {
                case STATIC_REFERENCE:
                    String name = reference.getName();
                    break;
                case INSTANCE_REFERENCE:
                    code.append(getStrategy().generate(reference));
                    break;
                case WEAK_REFERENCE:
                default:
                    break;
            }
        } catch (UnsupportedFormException e) {
            e.printStackTrace();
        }
        return code.toString();
    }
}
