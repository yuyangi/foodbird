package com.sub.common.gen.tools;

import com.sub.common.gen.constants.Constants;

/**
 * Created by yy111026 on 2017/2/6.
 */
public class CodeBuilder {

    private StringBuilder codeBuilder = new StringBuilder();

    public CodeBuilder() {

    }

    public CodeBuilder end() {
        codeBuilder.append(Constants.SENTENCE_END);
        return this;
    }

    public CodeBuilder append(String codes) {
        codeBuilder.append(codes);
        return this;
    }

    public CodeBuilder _import(String imports) {
        codeBuilder.append("import ").append(imports);
        return this;
    }

    public CodeBuilder _package(String packages) {
        codeBuilder.append("package ").append(packages);
        return this;
    }

    public CodeBuilder _public(String codes) {
        codeBuilder.append("public ").append(codes);
        return this;
    }

    public CodeBuilder _private(String codes) {
        codeBuilder.append("private ").append(codes);
        return this;
    }

    public CodeBuilder _protected(String codes) {
        codeBuilder.append("protected ").append(codes);
        return this;
    }

    public CodeBuilder _static(String codes) {
        codeBuilder.append("static ").append(codes);
        return this;
    }

    public CodeBuilder modifier(String modifier) {
        codeBuilder.append(modifier + " ");
        return this;
    }

    public CodeBuilder newLine() {
        codeBuilder.append(Constants.LINE_SEPARATOR);
        return this;
    }

    public String toString() {
        return codeBuilder.toString();
    }

    public StringBuilder getCodeBuilder() {
        return codeBuilder;
    }

}
