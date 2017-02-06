package com.sub.common.gen.meta;

import com.sub.common.gen.enums.Modifier;

public abstract class BaseCodeModel implements ICodeModel {

	private String name;
	private String code;
	private IPackage packages;
	private String level;
	private String module;
	private Modifier visibility;
	private Modifier modifier;
	private IClass parent;

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getCode() {
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

	@Override
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@Override
	public Modifier getVisibility() {
		return visibility;
	}

	public void setVisibility(Modifier visibility) {
		this.visibility = visibility;
	}

	@Override
	public Modifier getModifier() {
		return modifier;
	}

	public void setModifier(Modifier modifier) {
		this.modifier = modifier;
	}

	public IClass getParent() {
		return parent;
	}

	public void setParent(IClass parent) {
		this.parent = parent;
	}
	
}
