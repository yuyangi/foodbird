package com.sub.gen.meta.method;

import org.springframework.stereotype.Component;

import com.sub.gen.enums.MethodType;
import com.sub.gen.meta.IClass;
import com.sub.gen.tools.CodeBuilder;

/**
 * Created by yuyang on 2016/11/27.
 */
@Component("serviceQuery")
public class SpringServiceQuery extends SpringServiceMethod {

    private IClass entity;

    @Override
    public String getCode() {
        return "get" + entity.getCode() + "ByCondition";
    }

    @Override
    public String toCode() {
        CodeBuilder codeBuilder = new CodeBuilder(indent());
        codeBuilder.append("public " + getReturn() + " "+ getCode() + "(" + getParameterString() + ") " + getThrows() + " {").newLine();
        codeBuilder.append("    List<Project> projects = objectBo.query(condition);").newLine();
        codeBuilder.append("    List<ProjectDto> projectDtos = ProjectConverter.convertList(projects)").newLine();
        codeBuilder.append("    return projectDtos;").newLine();
        codeBuilder.append("}").newLine();
        return codeBuilder.toString();
    }

}
