package com.sub.gen.codes;

import com.sub.gen.constants.Constants;
import com.sub.gen.enums.Modifier;

public abstract class BaseCodeModel implements ICodeModel {

    private String id;
    private String name;
    private String code;
    private IPackage packages;
    private String level;
    private String module;
    private Modifier visibility;
    private Modifier modifier;
    private ICodeModel parent;
    private String comment;

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

    public ICodeModel getParent() {
        return parent;
    }

    public void setParent(ICodeModel parent) {
        this.parent = parent;
    }

    @Override
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String id() {
        return getId();
    }

    @Override
    public String code() {
        return getCode();
    }

    @Override
    public String name() {
        return getName();
    }

    public String indent() {
        int dep = depth(this);
        String indent = "";
        for (int i = 0; i < dep; i++) {
            indent += Constants.INDENT;
        }
        return indent;
    }

    private int depth(ICodeModel codeModel) {
        int dep = 0;
        if (codeModel.getParent() != null) {
            dep++;
            dep += depth(codeModel.getParent());
        }
        return dep;
    }

}
