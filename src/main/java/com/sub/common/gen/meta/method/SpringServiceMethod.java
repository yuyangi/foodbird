package com.sub.common.gen.meta.method;

import com.sub.common.gen.constants.Constants;
import com.sub.common.gen.enums.DataType;
import com.sub.common.gen.meta.*;
import com.sub.common.gen.tools.CodeBuilder;
import com.sub.common.gen.tools.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yy111026 on 2016/12/7.
 */
public abstract class SpringServiceMethod extends BaseCodeModel implements IMethod, Constants {

    private List<IParameter> parameters;

    private IType returnType;

    private List<IClass> _throws;

    private List<IClass> imports;

    private List<IClass> references;

    @Override
    public IParameter[] getParameters() {
        return parameters.toArray(new IParameter[0]);
    }

    @Override
    public IType getReturnType() {
        return returnType;
    }

    protected String getThrows() {
        if(_throws != null) {
            return " throw " + String.join(COMMA,CollectionUtils.convert(_throws, t -> t.getCode()));
        }
        return "";
    }

    protected String getReturn() {
        if(returnType != null) {
            if(Arrays.asList(DataType.Basics).contains(returnType.getType())) {
                return returnType.getType().name().toLowerCase();
            } else if(Arrays.asList(DataType.Objects).contains(returnType.getType())) {
                return returnType.getClassType() != null ? returnType.getClassType().getCode() : returnType.getClassType().getCode();
            }
        }
        return "void";
    }

    protected String getParameterString() {
        if(getParameters() != null) {
            CodeBuilder paramBuilder = new CodeBuilder();
            List<String> paramDef = new ArrayList<>();
            for (IParameter param : getParameters()) {
                paramDef.add(param.getType().getClassType().getCode() + " " + param.getCode());
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

    public List<IClass> get_throws() {
        return _throws;
    }

    public void set_throws(List<IClass> _throws) {
        this._throws = _throws;
    }

    public void setImports(List<IClass> imports) {
        this.imports = imports;
    }

    public List<IClass> getReferences() {
        return references;
    }

    public void setReferences(List<IClass> references) {
        this.references = references;
    }
}
