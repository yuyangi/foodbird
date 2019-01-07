package com.foodbird.generate.java.codes.method;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.codes.*;
import com.foodbird.generate.java.codes.metas.Charactor;
import com.foodbird.generate.java.codes.type.Type;
import com.foodbird.generate.java.common.*;
import com.foodbird.generate.java.constants.Constants;
import com.foodbird.generate.java.enums.DataType;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.enums.MethodType;
import com.foodbird.generate.java.tools.CollectionUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

import static com.foodbird.generate.java.codes.metas.Brackets.PARENTHESIS;

/**
 * Created by yy111026 on 2017/2/6.
 */
public abstract class Method extends BaseCodeModel implements IMethod, Constants {

    protected List<IParameter> parameters;

    private IType returnType;

    private List<IClass> exceptions;

    private List<IClass> imports;

    private MethodType methodType;

    private List<IReference> references;

    @Override
    public IParameter[] getParameters() {
        return parameters.toArray(new IParameter[0]);
    }

    @Override
    public IType getReturnType() {
        if (returnType == null) {
            return Type.typeVoid;
        }
        return returnType;
    }

    protected String getThrows() {
        if(exceptions != null) {
            return " throw " + String.join(COMMA, CollectionUtils.convert(exceptions, t -> t.getCode()));
        }
        return "";
    }

    protected String getReturn() {
        if(getReturnType() != null) {
            return getReturnType().getTypeClass() != null ? getReturnType().getTypeClass().getCode() : getReturnType().getTypeClass().getCode();
        }
        return DataType.VOID.name().toLowerCase();
    }

    @Override
    public List<IClass> getImports() {
        if (imports == null) {
            Set<IClass> ims = Sets.newHashSet();
            if (parameters != null) {
                parameters.forEach(p -> ims.add(p.getType().getTypeClass()));
            }
            if (returnType != null) {
                ims.add(returnType.getTypeClass());
            }
            if (exceptions != null) {
                ims.addAll(exceptions);
            }
            if (references != null) {
                references.forEach(r -> ims.add(r.getReference()));
            }
            imports = Lists.newArrayList(ims);
        }
        return imports;
    }

    public void setParameters(List<IParameter> parameters) {
        this.parameters = parameters;
    }

    public void setReturnType(IType returnType) {
        this.returnType = returnType;
    }

    public List<IClass> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<IClass> exceptions) {
        this.exceptions = exceptions;
    }

    public void setImports(List<IClass> imports) {
        this.imports = imports;
    }

    public List<IReference> getReferences() {
        return references;
    }

    public void setReferences(List<IReference> references) {
        this.references = references;
    }

    @Override
    public MethodType getMethodType() {
        return MethodType.Normal;
    }

    @Override
    public MetaType getMetaType() {
        return MetaType.Method;
    }

    @Override
    public String toCode() {
        return IndentSection.create(WORD_SEPARATOR, IndentSection.create("", methodDefine(), paramDefine()), methodBody()).indent(getIndent()).toCode();
    }

    public Section methodDefine() {
        return Sentence.sentence(WORD_SEPARATOR, getVisibility(), getReturnType(), methodName());
    }

    private ICoder paramDefine() {
        return Body.paramBody(Phrase.phrase(Charactor.COMMA.toCode(), getParameters()));
    }

    public abstract Section methodBody();

    public abstract Word methodName();

}
