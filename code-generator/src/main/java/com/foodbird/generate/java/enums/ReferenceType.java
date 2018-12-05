package com.foodbird.generate.java.enums;

import com.foodbird.generate.java.codes.StrategySelective;

/**
 * Created by yy111026 on 2017/2/8.
 */
public enum ReferenceType implements StrategySelective {

    STATIC_REFERENCE, INSTANCE_REFERENCE, WEAK_REFERENCE;

    @Override
    public String key() {
        return getClass().getName();
    }

    @Override
    public Object value() {
        return this;
    }
}
