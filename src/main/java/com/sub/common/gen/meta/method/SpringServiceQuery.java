package com.sub.common.gen.meta.method;

import com.sub.common.gen.tools.CodeBuilder;
import com.sub.common.gen.tools.Segment;
import org.springframework.stereotype.Component;

/**
 * Created by yuyang on 2016/11/27.
 */
@Component("serviceQuery")
public class SpringServiceQuery extends SpringServiceMethod {

    @Override
    public String toCode() {
        CodeBuilder codeBuilder = new CodeBuilder();
        codeBuilder.append(indent()).append("public " + getReturn() + " "+ getCode() + "(ProjectCondition condition)" + getThrows() + " {").newLine();
        codeBuilder.append(indent()).append("    List<Project> projects = objectBo.query(condition);").newLine();
        codeBuilder.append(indent()).append("    List<ProjectDto> projectDtos = ProjectConverter.convertList(projects)").newLine();
        codeBuilder.append(indent()).append("    return projectDtos;").newLine();
        codeBuilder.append(indent()).append("}").newLine();
        return codeBuilder.toString();
    }

}
