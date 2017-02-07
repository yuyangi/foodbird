package com.sub.common.gen.meta;

import com.sub.common.gen.constants.Constants;
import com.sub.common.gen.meta.method.Getter;
import com.sub.common.gen.meta.method.Setter;
import com.sub.common.gen.tools.CodeBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yy111026 on 2017/2/6.
 */
public class Class extends BaseCodeModel implements IClass {

    private List<IAttribute> attributes;

    private List<IMethod> methods;

    private IPackage packages;

    private List<IClass> generics;

    @Override
    public List<IAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<IAttribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public List<IMethod> getMethods() {
        if (methods == null) {
            methods = new ArrayList<>();
            if (attributes != null) {
                attributes.forEach(a -> methods.add(new Getter(a, this)));
                attributes.forEach(a -> methods.add(new Setter(a, this)));
            }
        }
        return methods;
    }

    public void setMethods(List<IMethod> methods) {
        this.methods = methods;
    }

    @Override
    public IPackage getPackages() {
        return packages;
    }

    @Override
    public void setPackages(IPackage packages) {
        this.packages = packages;
    }

    @Override
    public List<IClass> getGenerics() {
        return generics;
    }

    public void setGenerics(List<IClass> generics) {
        this.generics = generics;
    }

    @Override
    public String toCode() {
        CodeBuilder codes = new CodeBuilder();
        // package line
        codes._package(String.join(".", getPackages().getPackages())).end();
        codes.append(Constants.LINE_SEPARATOR);
        // _import
        codes._import("java.util.*").end();

        boolean hasAttribute = attributes != null;

        if (hasAttribute) {
            hasAttribute = true;
            attributes.stream().filter(attr -> attr.getType().getClassType() != null).forEach(
                    attr -> codes._import(attr.getType().getClassType().getPackages() + "." + attr.getType().getClassType().getCode()));
        }
        // class body
        codes.append(Constants.LINE_SEPARATOR);
        // attributes
        codes._public("class ").append(getCode() + " {").append(Constants.LINE_SEPARATOR);
        if (hasAttribute) {
            attributes.forEach(attr -> codes.append(attr.toCode()));
        }
        // methods
        getMethods().forEach(method -> codes.append(method.toCode()).newLine());
        codes.append("}").append(Constants.LINE_SEPARATOR);
        return codes.toString();
    }
}
