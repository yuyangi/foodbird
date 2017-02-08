package com.sub.common.gen.meta.method;

import com.sub.common.gen.meta.IClass;
import com.sub.common.gen.tools.CodeBuilder;
import com.sub.common.gen.tools.Segment;
import org.springframework.stereotype.Component;

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
