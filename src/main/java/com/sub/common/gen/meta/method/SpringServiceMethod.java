package com.sub.common.gen.meta.method;

import com.sub.common.gen.constants.Constants;
import com.sub.common.gen.enums.DataType;
import com.sub.common.gen.meta.*;
import com.sub.common.gen.tools.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yy111026 on 2016/12/7.
 */
public abstract class SpringServiceMethod extends BaseCodeModel implements IMethod, Constants {

    private IClass parent;

    private List<IParameter> parameters;

    private IType returnType;

    private List<IClass> _throws;

    @Override
    public IParameter[] getParameters() {
        return parameters.toArray(new IParameter[0]);
    }

    @Override
    public IType getReturnType() {
        return returnType;
    }

    @Override
    public String toCode() {
        StringBuilder codeBuilder = new StringBuilder();
        codeBuilder.append("public " + getReturn() + " "+ getCode() + "(ProjectCondition condition)" + getThrows() + " {").append(LINE_SEPARATOR);
        codeBuilder.append("    List<Project> projects = objectBo.query(condition);").append(LINE_SEPARATOR);
        codeBuilder.append("    List<ProjectDto> projectDtos = ProjectConverter.convertList(projects)").append(LINE_SEPARATOR);
        codeBuilder.append("    return projectDtos;").append(LINE_SEPARATOR);
        codeBuilder.append("}").append(LINE_SEPARATOR);
        return codeBuilder.toString();
    }

    private String getThrows() {
        if(_throws != null) {
            return " throw " + String.join(COMMA,CollectionUtils.convert(_throws, t -> t.getCode()));
        }
        return "";
    }

    private String getReturn() {
        if(returnType != null) {
            if(returnType.getType() == DataType.VOID) {
                return "void";
            } else if(Arrays.asList(DataType.Basics).contains(returnType.getType())) {
                return returnType.getType().name().toLowerCase();
            } else if(Arrays.asList(DataType.Objects).contains(returnType.getType())) {
                return returnType.getClassType() != null ? returnType.getClassType().getCode() : returnType.getClassType().getCode();
            }
        }
        return "void";
    }

    @Override
    public List<IClass> getImports() {
        return null;
    }
}
