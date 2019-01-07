package com.foodbird.generate.java.common;

import com.foodbird.generate.java.codes.IClass;
import com.foodbird.generate.java.codes.metas.Definitions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/6
 */
public class Imports extends Section {

    private IClass[] imports;

    public Imports(IClass... imports) {
        super(LINE_SEPARATOR);
        this.imports = imports;
    }

    @Override
    public String toCode() {
        if (imports != null) {
            return Section.create(Arrays.stream(imports).
                    sorted(Comparator.comparing(IClass::getQualifiedName)).
                    map(this::sentence).toArray(Sentence[]::new)).toCode();
        }
        return null;
    }

    private Sentence sentence(IClass iClass) {
        return Sentence.sentence(Definitions.IMPORT, Word.create(iClass.getQualifiedName())).end();
    }

    public static Imports imports(IClass... classes) {
        return new Imports(classes);
    }

}
