package com.foodbird.generate.java.codes;

import com.foodbird.generate.java.enums.Modifier;
import com.foodbird.generate.java.enums.ObjectType;

public abstract class BaseCodeModel implements ICodeModel, Indented {

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
    private ObjectType objectType;
    private String indent;
    private boolean passed;

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

    @Override
    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    @Override
    public String getIndent() {
        return indent;
    }

    @Override
    public void setIndent(String indent) {
        this.indent = (this.indent == null) ? indent : (this.indent + indent);
    }

    @Override
    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
