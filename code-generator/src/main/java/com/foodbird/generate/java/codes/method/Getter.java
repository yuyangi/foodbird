package com.foodbird.generate.java.codes.method;

import com.foodbird.generate.java.codes.*;
import com.foodbird.generate.java.codes.metas.Definitions;
import com.foodbird.generate.java.common.Section;
import com.foodbird.generate.java.common.Body;
import com.foodbird.generate.java.common.Sentence;
import com.foodbird.generate.java.common.Word;
import com.foodbird.generate.java.constants.Constants;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.enums.MethodType;
import com.foodbird.generate.java.enums.Modifier;
import org.springframework.stereotype.Component;

/**
 * Created by yuyang on 2016/11/27.
 */
@Component("getter")
public class Getter extends Method implements Constants {

    private IAttribute attribute;

    private MethodType methodType;

    public Getter() {

    }

    public Getter(IAttribute attribute, ICodeModel parent) {
        super();
        this.attribute = attribute;
        this.setParent(parent);
    }

    @Override
    public IParameter[] getParameters() {
        return new IParameter[0];
    }

    @Override
    public IType getReturnType() {
        return attribute.getType();
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
    public Section methodBody() {
        return Body.methodBody(Sentence.sentence(Definitions.RETURN, Word.create(getAttribute().getCode())).end());
    }

    public Word methodName() {
        return Word.create(getter());
    }

    public String getter() {
        return "get" + attribute.getCode().substring(0, 1).toUpperCase() + attribute.getCode().substring(1);
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

    @Override
    public MetaType getMetaType() {
        return MetaType.Method;
    }
}
