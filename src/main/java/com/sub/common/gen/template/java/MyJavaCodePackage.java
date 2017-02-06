package com.sub.common.gen.template.java;

import com.sub.common.gen.meta.ICoder;
import com.sub.common.gen.packages.ICodePackage;

import java.util.List;

/**
 * Created by yy111026 on 2017/2/4.
 */
public class MyJavaCodePackage implements ICodePackage {

    private static MyJavaCodePackage ourInstance = new MyJavaCodePackage();

    public static MyJavaCodePackage getInstance() {
        return ourInstance;
    }

    private String language;

    private String module;

    private String level;

    private List<ICoder> codes;

    private MyJavaCodePackage() {
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
