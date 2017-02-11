package com.sub.common.gen.meta.classes;

import com.sub.common.gen.constants.Constants;
import com.sub.common.gen.meta.*;
import com.sub.common.gen.meta.packages.Package;
import com.sub.common.gen.tools.CodeBuilder;

import java.util.List;

/**
 * Created by yy111026 on 2017/2/8.
 */
public class ClassAdapter extends BaseCodeModel implements IClass {

    private Class<?> clz;

    private int lastIndexOfDot = 0;

    private int fullNameLength = 0;

    public ClassAdapter(Class<?> clz, ICodeModel parent) {
        this(clz);
        super.setParent(parent);
    }

    public ClassAdapter(Class<?> clz) {
        this.clz = clz;
        lastIndexOfDot = clz.getName().lastIndexOf('.');
        fullNameLength = clz.getName().length();
    }

    public ClassAdapter() {

    }

    @Override
    public List<IAttribute> getAttributes() {
        return null;
    }

    @Override
    public List<IMethod> getMethods() {
        return null;
    }

    @Override
    public List<IClass> getGenerics() {
        return null;
    }

    @Override
    public String getName() {
        return clz.getName().substring(lastIndexOfDot + 1, fullNameLength);
    }

    @Override
    public IPackage getPackages() {
        if (super.getPackages() == null) {
            setPackages(new Package(clz.getName().substring(0, lastIndexOfDot)));
        }
        return super.getPackages();
    }

    @Override
    public String getCode() {
        return clz.getName().substring(lastIndexOfDot + 1, fullNameLength);
    }

    @Override
    public String toCode() {
        CodeBuilder codes = new CodeBuilder();
        return codes.toString();
    }
}
