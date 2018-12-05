package com.foodbird.generate.java.tools;

import com.foodbird.generate.java.codes.ICodeModel;
import com.foodbird.generate.java.constants.Constants;
import com.foodbird.generate.java.enums.Modifier;

/**
 * Created by yy111026 on 2017/2/6.
 */
public class CodeBuilder {

    private StringBuilder codeBuilder = new StringBuilder();

    private String indent = "";

    public CodeBuilder() {

    }

    public CodeBuilder(String indent) {
        this.indent = indent;
    }

    public CodeBuilder end() {
        codeBuilder.append(Constants.SENTENCE_END);
        return this;
    }

    public CodeBuilder append(String codes) {
        codeBuilder.append(indent).append(indent).append(codes);
        return this;
    }

    public CodeBuilder addImport(String imports) {
        codeBuilder.append(indent).append(indent).append("import ").append(imports);
        return this;
    }

    public CodeBuilder addPackage(String packages) {
        codeBuilder.append(indent).append("package ").append(packages);
        return this;
    }

    public CodeBuilder addModifier(Modifier modifier, String modifyTo) {
        codeBuilder.append(indent).append(modifier.name().toLowerCase() + " ").append(modifyTo);
        return this;
    }
    
    public CodeBuilder _public(String codes) {
        codeBuilder.append(indent).append("public ").append(codes);
        return this;
    }

    public CodeBuilder _private(String codes) {
        codeBuilder.append(indent).append("private ").append(codes);
        return this;
    }

    public CodeBuilder _protected(String codes) {
        codeBuilder.append(indent).append("protected ").append(codes);
        return this;
    }

    public CodeBuilder _static(String codes) {
        codeBuilder.append(indent).append("static ").append(codes);
        return this;
    }

    public CodeBuilder modifier(String modifier) {
        codeBuilder.append(indent).append(modifier + " ");
        return this;
    }

    public CodeBuilder invoke() {
        codeBuilder.append(".");
        return this;
    }

    public CodeBuilder assign(String valueExp) {
        codeBuilder.append(indent).append(" = ").append(valueExp);
        return this;
    }

    public CodeBuilder newLine() {
        codeBuilder.append(Constants.LINE_SEPARATOR);
        return this;
    }

    public CodeBuilder append(ICodeModel model) {
        codeBuilder.append(indent).append(model.toCode());
        return this;
    }

    public String toString() {
        return codeBuilder.toString();
    }

    public StringBuilder getCodeBuilder() {
        return codeBuilder;
    }

}
