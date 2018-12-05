package com.foodbird.generate.java.codes.classes;

import com.foodbird.generate.java.codes.IMethod;
import com.foodbird.generate.java.codes.method.Getter;
import com.foodbird.generate.java.codes.method.JConstructor;
import com.foodbird.generate.java.codes.method.Setter;
import com.foodbird.generate.java.codes.type.Type;
import com.foodbird.generate.java.constants.Constants;
import com.foodbird.generate.java.tools.CodeBuilder;
import com.foodbird.generate.java.tools.NameUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Entity extends BaseClass {

    public List<IMethod> getMethods() {
        if (methods == null) {
            methods = new ArrayList<>();
            if (attributes != null) {
                attributes.forEach(a ->
                {
                    methods.add(new Getter(a, this));
                    methods.add(new Setter(a, this));
                });
            }
        }
        return methods;
    }

    @Override
    public List<IMethod> getConstructors() {
        if (constructors == null) {
            constructors = new ArrayList<>();
            JConstructor constructor = new JConstructor();
            constructor.setParent(this);
            Type returnType = new Type();
            returnType.setType(this);
            constructor.setReturnType(returnType);
            constructors.add(constructor);
        }
        return constructors;
    }

    @Override
    public String getVarName() {
        if (varName == null) {
            varName = NameUtils.getVarName(getCode());
        }
        return varName;
    }

    @Override
    public String toCode() {
        CodeBuilder codes = new CodeBuilder();
        // packages line
        codes.addPackage(String.join(".", getPackages().getPackages())).end();
        codes.append(Constants.LINE_SEPARATOR).newLine();
        // _import
        Set<String> imports = new HashSet<String>();
        boolean hasAttribute = attributes != null;
        if (hasAttribute) {
            hasAttribute = true;
            attributes.stream().filter(attr -> attr.getType().getType() != null).forEach(
                    attr -> imports.add(attr.getType().getType().getPackages().toString() + "." + attr.getType().getType().getCode()));
        }
        imports.forEach(imp -> codes.addImport(imp).end().newLine());
        // class body
        codes.newLine();
        // attributes
        codes._public("class ").append(getCode() + " {").newLine().newLine();
        if (hasAttribute) {
            attributes.forEach(attr -> codes.append(attr.toCode()).newLine());
        }
        // methods
        getMethods().forEach(method -> codes.append(method.toCode()).newLine());
        codes.append(RIGHT_BRACE).append(Constants.LINE_SEPARATOR);
        return codes.toString();
    }
}
