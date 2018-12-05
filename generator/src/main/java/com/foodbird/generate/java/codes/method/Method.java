package com.foodbird.generate.java.codes.method;

import com.foodbird.generate.java.codes.*;
import com.foodbird.generate.java.codes.metas.Charactor;
import com.foodbird.generate.java.common.Block;
import com.foodbird.generate.java.common.Body;
import com.foodbird.generate.java.constants.Constants;
import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.enums.MethodType;
import com.foodbird.generate.java.tools.CodeBuilder;
import com.foodbird.generate.java.tools.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yy111026 on 2017/2/6.
 */
public abstract class Method extends BaseCodeModel implements IMethod, Constants {

    private List<IParameter> parameters;

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
        return returnType;
    }

    protected String getThrows() {
        if(exceptions != null) {
            return " throw " + String.join(COMMA, CollectionUtils.convert(exceptions, t -> t.getCode()));
        }
        return "";
    }

    protected String getReturn() {
        if(returnType != null) {
            return returnType.getType() != null ? returnType.getType().getCode() : returnType.getType().getCode();
        }
        return "void";
    }

    protected String getParameterString() {
        if(getParameters() != null) {
            CodeBuilder paramBuilder = new CodeBuilder();
            List<String> paramDef = new ArrayList<>();
            for (IParameter param : getParameters()) {
                paramDef.add(param.getType().getType().getCode() + " " + param.getCode());
            }
            paramBuilder.append(String.join(", ", paramDef));
            return paramBuilder.toString();
        }
        return null;
    }

    @Override
    public List<IClass> getImports() {
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
        return Block.create(Charactor.SPACE.toCode(), methodDefine(), methodBody()).toCode();
    }

    public Block methodDefine() {

        return null;
    }

    public abstract Body methodBody();

}
