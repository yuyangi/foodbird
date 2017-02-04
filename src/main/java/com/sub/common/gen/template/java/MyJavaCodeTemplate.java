package com.sub.common.gen.template.java;

import com.sub.common.gen.model.IClass;
import com.sub.common.gen.model.ICoder;
import com.sub.common.gen.template.ICodeTemplate;

import java.util.List;

/**
 * Created by yy111026 on 2017/2/4.
 */
public class MyJavaCodeTemplate implements ICodeTemplate {

    private static MyJavaCodeTemplate ourInstance = new MyJavaCodeTemplate();

    public static MyJavaCodeTemplate getInstance() {
        return ourInstance;
    }

    private String language;

    private String module;

    private String level;

    private List<ICoder> codes;

    private MyJavaCodeTemplate() {
    }

    @Override
    public String getLanguage() {
        return "Java";
    }

    @Override
    public String getModule() {
        return "Business";
    }

    @Override
    public String getLevel() {
        return "DTO";
    }

    @Override
    public List<ICoder> getCoders() {
        return null;
    }

    @Override
    public void generate() {

    }

    @Override
    public String toCode() {
        return null;
    }
}
