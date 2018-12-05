package com.foodbird.generate.java.enums;

import com.foodbird.generate.java.codes.StrategySelective;

/**
 * Created by yy111026 on 2017/2/9.
 */
public enum MetaType implements StrategySelective {

    Attribute,
    Class,
    Method,
    Type,
    Parameter,
    Reference,
    ;

    @Override
    public String key() {
        return getClass().getName();
    }

    @Override
    public Object value() {
        return this;
    }
}
