package com.sub.common.gen.model.impl;

import com.sub.common.gen.enums.Modifier;
import com.sub.common.gen.model.IClass;
import com.sub.common.gen.model.ICodeModel;
import com.sub.common.gen.model.IPackage;

public abstract class BaseCodeModel implements ICodeModel {

	private String name;
	private String code;
	private IPackage packages;
	private String level;
	private String module;
	private Modifier visibility;
	private Modifier modifier;
	private IClass parent;
	
	public Modifier getVisibility() {
		return visibility;
	}

	public void setVisibility(Modifier visibility) {
		this.visibility = visibility;
	}

	public Modifier getModifier() {
		return modifier;
	}

	public void setModifier(Modifier modifier) {
		this.modifier = modifier;
	}

	public String name() {
		return name;
	}

	public IPackage packages() {
		return packages;
	}

	public String level() {
		return level;
	}

	public String module() {
		return module;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public String code() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public IPackage getPackages() {
		return packages;
	}

	public void setPackages(IPackage packages) {
		this.packages = packages;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Modifier visibility() {
		return visibility;
	}

	public Modifier modifier() {
		return modifier;
	}

	public IClass parent() {
		return parent;
	}

}
