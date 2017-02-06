package com.sub.common.gen.tools;

import com.sub.common.gen.constants.Constants;

/**
 * Created by yy111026 on 2017/2/6.
 */
public class CodeBuilder {

    private StringBuilder codeBuilder = new StringBuilder();

    public CodeBuilder end() {
        codeBuilder.append(Constants.SENTENCE_END);
        return this;
    }

    public CodeBuilder append(String codes) {
        codeBuilder.append(codes);
        return this;
    }

    public CodeBuilder imports(String imports) {
        codeBuilder.append("import ").append(imports);
        return this;
    }

    public CodeBuilder packages(String packages) {
        codeBuilder.append("package ").append(packages);
        return this;
    }

    public CodeBuilder publics(String codes) {
        codeBuilder.append("public ").append(codes);
        return this;
    }

    public CodeBuilder privates(String codes) {
        codeBuilder.append("private ").append(codes);
        return this;
    }

    public CodeBuilder protecteds(String codes) {
        codeBuilder.append("protected ").append(codes);
        return this;
    }

    public CodeBuilder statics(String codes) {
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

}
