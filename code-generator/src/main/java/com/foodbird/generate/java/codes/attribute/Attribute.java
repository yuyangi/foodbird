package com.foodbird.generate.java.codes.attribute;

import com.foodbird.generate.java.codes.BaseCodeModel;
import com.foodbird.generate.java.codes.IAttribute;
import com.foodbird.generate.java.codes.IType;
import com.foodbird.generate.java.common.Sentence;
import com.foodbird.generate.java.common.Word;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.tools.CodeBuilder;
import com.foodbird.generate.java.tools.NameUtils;

/**
 * @author yy111026 on 2017/2/6.
 */
public class Attribute extends BaseCodeModel implements IAttribute {

    private IType type;

    @Override
    public IType getType() {
        return type;
    }

    public void setType(IType type) {
        this.type = type;
    }

    @Override
    public String toCode() {
        return Sentence.sentence(getVisibility(), getModifier(), getType(),
                Word.create(NameUtils.getVarName(getCode()))).end().toCode();
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Attribute;
    }
}
