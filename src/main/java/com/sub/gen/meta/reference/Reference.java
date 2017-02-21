package com.sub.gen.meta.reference;

import com.sub.gen.enums.InstanceMode;
import com.sub.gen.enums.MetaType;
import com.sub.gen.enums.ReferenceForm;
import com.sub.gen.enums.ReferenceType;
import com.sub.gen.meta.BaseCodeModel;
import com.sub.gen.meta.IClass;
import com.sub.gen.meta.IMethod;
import com.sub.gen.meta.IReference;
import com.sub.gen.strategy.ICodeGenerateStrategy;
import com.sub.gen.strategy.factory.DefaultCodeGenerateStrategyFactory;
import com.sub.gen.strategy.factory.ICodeGenerateStrategyFactory;
import com.sub.gen.strategy.form.DefaultFormStrategy;
import com.sub.gen.tools.CodeBuilder;

import java.util.List;

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

    private List<IReference> dependencies;

    private ICodeGenerateStrategyFactory factory = DefaultCodeGenerateStrategyFactory.getInstance();

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

    @Override
    public List<IReference> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<IReference> dependencies) {
        this.dependencies = dependencies;
    }

    private ICodeGenerateStrategy getStrategy() {
        ICodeGenerateStrategy strategy = factory.create(getReferenceForm());
        if (strategy == null) {
            strategy = new DefaultFormStrategy();
        }
        return strategy;
    }

    @Override
    public String toCode() {
        CodeBuilder code = new CodeBuilder();
        switch (referenceType) {
            case STATIC_REFERENCE:
                // TODO
                String name = reference.getName();
                break;
            case INSTANCE_REFERENCE:
                code.append(getStrategy().generate(reference));
                break;
            case WEAK_REFERENCE:
                // TODO
            default:
                break;
        }
        return code.toString();
    }
}
