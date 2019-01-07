package com.foodbird.generate.java.codes.method;

import com.foodbird.generate.java.codes.*;
import com.foodbird.generate.java.codes.metas.Brackets;
import com.foodbird.generate.java.codes.metas.Charactor;
import com.foodbird.generate.java.codes.metas.Operators;
import com.foodbird.generate.java.codes.metas.This;
import com.foodbird.generate.java.codes.type.Parameter;
import com.foodbird.generate.java.common.Section;
import com.foodbird.generate.java.common.Body;
import com.foodbird.generate.java.common.Sentence;
import com.foodbird.generate.java.common.Word;
import com.foodbird.generate.java.constants.Constants;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.enums.MethodType;
import com.foodbird.generate.java.enums.Modifier;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yuyang on 2016/11/27.
 */
@Component("setter")
public class Setter extends Method implements Constants {

    private IAttribute attribute;

    private MethodType methodType;

    private List<IReference> references;

    public Setter() {
        super();
        this.setReturnType(null);
    }

    public Setter(IAttribute attribute, ICodeModel parent) {
        this();
        this.attribute = attribute;
        this.setParent(parent);
    }

    @Override
    public Modifier getVisibility() {
        return Modifier.PUBLIC;
    }

    @Override
    public Modifier getModifier() {
        return null;
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Method;
    }

    @Override
    public List<IReference> getReferences() {
        return references;
    }

    public void setReferences(List<IReference> references) {
        this.references = references;
    }

    @Override
    public Section methodBody() {
        if (getParameters() != null && getParameters().length > 0) {
            return Body.methodBody(Sentence.sentence(Word.create(This.THIS.toCode()+Charactor.POINT.toCode()+getAttribute().getCode()),
                    Operators.ASSIGN, Word.create(getParameters()[0].getCode())).end()
                    );
        }
        return new Body();
    }

    @Override
    public IParameter[] getParameters() {
        if (parameters == null) {
            parameters = Lists.newArrayList();
            Parameter parameter = new Parameter();
            parameter.setType(attribute.getType());
            parameter.setName(attribute.getName());
            parameter.setCode(attribute.getCode());
            parameters.add(parameter);
        }
        return parameters.toArray(new IParameter[0]);
    }

    @Override
    public Word methodName() {
        return Word.create(setter());
    }

    private String setter() {
        return "set" + attribute.getCode().substring(0, 1).toUpperCase() + attribute.getCode().substring(1);
    }

    public IAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(IAttribute attribute) {
        this.attribute = attribute;
    }

    @Override
    public MethodType getMethodType() {
        return methodType;
    }

    public void setMethodType(MethodType methodType) {
        this.methodType = methodType;
    }
}
