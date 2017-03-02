package com.sub.gen.template.java;

import java.util.List;

import com.sub.gen.ICoder;
import com.sub.gen.collection.ICodePackage;

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
        return module;
    }

    @Override
    public String getLevel() {
        return level;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<ICoder> getCodes() {
		return codes;
	}

	public void setCodes(List<ICoder> codes) {
		this.codes = codes;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public void setLevel(String level) {
		this.level = level;
	}
    
}
