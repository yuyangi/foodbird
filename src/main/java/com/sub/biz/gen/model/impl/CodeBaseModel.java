package com.sub.biz.gen.model.impl;

import com.sub.biz.gen.model.ICodeModel;

public class CodeBaseModel implements ICodeModel {

	private String name;
	private String id;
	private String packages;
	private String level;
	private String module;
	
	public String name() {
		return name;
	}

	public String id() {
		return id;
	}

	public String packages() {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
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
	
}
