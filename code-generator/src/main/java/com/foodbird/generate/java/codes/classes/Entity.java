package com.foodbird.generate.java.codes.classes;

import com.foodbird.generate.java.codes.IMethod;
import com.foodbird.generate.java.codes.method.Getter;
import com.foodbird.generate.java.codes.method.JConstructor;
import com.foodbird.generate.java.codes.method.Setter;
import com.foodbird.generate.java.codes.type.Type;
import com.foodbird.generate.java.tools.NameUtils;

import java.util.ArrayList;
import java.util.List;

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

}
