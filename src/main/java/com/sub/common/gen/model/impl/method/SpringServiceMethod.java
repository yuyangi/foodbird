package com.sub.common.gen.model.impl.method;

import com.sub.common.gen.constants.IConstants;
import com.sub.common.gen.enums.Type;
import com.sub.common.gen.model.IClass;
import com.sub.common.gen.model.IMethod;
import com.sub.common.gen.model.IParameter;
import com.sub.common.gen.model.IType;
import com.sub.common.gen.model.impl.BaseCodeModel;
import com.sub.common.gen.tools.CollectionUtils;
import com.sub.common.gen.tools.Segment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yy111026 on 2016/12/7.
 */
public abstract class SpringServiceMethod extends BaseCodeModel implements IMethod, IConstants {

    private IClass parent;

    private List<IParameter> parameters;

    private IType returnType;

    private List<IClass> _throws;

    @Override
    public IParameter[] parameters() {
        return parameters.toArray(new IParameter[0]);
    }

    @Override
    public IType returnType() {
        return returnType;
    }

    @Override
    public String toCode() {
        StringBuilder codeBuilder = new StringBuilder();
        codeBuilder.append("public " + getReturn() + " "+ code() + "(ProjectCondition condition)" + getThrows() + " {").append(LINE_SEPARATOR);
        codeBuilder.append("    List<Project> projects = objectBo.query(condition);").append(LINE_SEPARATOR);
        codeBuilder.append("    List<ProjectDto> projectDtos = ProjectConverter.convertList(projects)").append(LINE_SEPARATOR);
        codeBuilder.append("    return projectDtos;").append(LINE_SEPARATOR);
        codeBuilder.append("}").append(LINE_SEPARATOR);
        return codeBuilder.toString();
    }

    public abstract Segment methodBody();

    private String getParameters() {
        if(parameters != null) {

        }
        return "";
    }

    private String getThrows() {
        if(_throws != null) {
            return " throw " + String.join(COMMA,CollectionUtils.convert(_throws, t -> t.code()));
        }
        return "";
    }

    private String getReturn() {
        if(returnType != null) {
            if(returnType.type() == Type.VOID) {
                return "void";
            } else if(Arrays.asList(Type.Basics).contains(returnType.type())) {
                return returnType.type().name().toLowerCase();
            } else if(Arrays.asList(Type.Objects).contains(returnType.type())) {
                return returnType.classType() != null ? returnType.classType().code() : returnType.code();
            }
        }
        return "void";
    }

}
