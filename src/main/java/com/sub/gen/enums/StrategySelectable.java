package com.sub.gen.enums;

import com.sub.gen.codes.StrategySelective;

/**
 * @author yy111026 on 2017/2/21.
 */
public abstract class StrategySelectable implements StrategySelective {

    @Override
    public String key() {
        return getClass().getName();
    }

    @Override
    public Object value() {
        return this;
    }
}
