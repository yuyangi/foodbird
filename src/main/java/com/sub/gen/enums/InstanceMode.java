package com.sub.gen.enums;

import com.sub.gen.codes.StrategySelective;

/**
 * Created by yy111026 on 2017/2/8.
 */
public enum InstanceMode implements StrategySelective {

    INJECTION, NEW, FACTORY;

    @Override
    public String key() {
        return getClass().getName();
    }

    @Override
    public Object value() {
        return this;
    }
}
