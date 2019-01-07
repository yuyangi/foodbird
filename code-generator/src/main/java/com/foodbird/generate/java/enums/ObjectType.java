package com.foodbird.generate.java.enums;

import com.foodbird.generate.java.ICoder;

/**
 * @author yuyang48
 * @project com.foodbird.coder
 * @date 2018/12/6
 */
public enum ObjectType implements ICoder {

    CLASS,
    INTERFACE,
    ENUM,
    ANNOTATION;


    @Override
    public String toCode() {
        switch (this) {
            case ENUM:
            case CLASS:
            case INTERFACE:
                return name().toLowerCase();
            case ANNOTATION:
                return "@" + INTERFACE.name().toLowerCase();
            default:
                return name().toLowerCase();
        }
    }
}
