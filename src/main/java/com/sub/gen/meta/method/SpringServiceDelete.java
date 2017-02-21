package com.sub.gen.meta.method;

import com.sub.gen.enums.MethodType;
import com.sub.gen.tools.CodeBuilder;
import com.sub.gen.tools.Segment;
import org.springframework.stereotype.Component;

/**
 * Created by yuyang on 2016/11/27.
 */
@Component("serviceDelete")
public class SpringServiceDelete extends SpringServiceMethod {
    
    public Segment methodBody() {
        return null;
    }

    @Override
    public String toCode() {
        CodeBuilder codeBuilder = new CodeBuilder();
        codeBuilder.append("public void ");
        return codeBuilder.toString();
    }

}
