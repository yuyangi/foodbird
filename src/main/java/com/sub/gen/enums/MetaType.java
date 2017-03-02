package com.sub.gen.enums;

import com.sub.gen.interfaces.StrategySelective;

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
