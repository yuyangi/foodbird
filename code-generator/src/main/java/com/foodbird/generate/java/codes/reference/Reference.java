package com.foodbird.generate.java.codes.reference;

import com.foodbird.generate.java.codes.*;
import com.foodbird.generate.java.enums.InstanceMode;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.enums.ReferenceForm;
import com.foodbird.generate.java.enums.ReferenceType;
import com.foodbird.generate.java.strategy.ICodeGenerateStrategy;
import com.foodbird.generate.java.strategy.factory.DefaultCodeGenerateStrategyFactory;
import com.foodbird.generate.java.strategy.factory.ICodeGenerateStrategyFactory;
import com.foodbird.generate.java.strategy.form.DefaultFormStrategy;
import com.foodbird.generate.java.tools.CodeBuilder;

import java.util.Map;

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

    private Map<String, ICodeModel> parameterBindings;

    private ICodeGenerateStrategyFactory factory = DefaultCodeGenerateStrategyFactory.getInstance();

    private String returnName;

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
    public String getReturnName() {
        return returnName;
    }

    @Override
    public void setReturnName(String returnName) {
        this.returnName = returnName;
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
