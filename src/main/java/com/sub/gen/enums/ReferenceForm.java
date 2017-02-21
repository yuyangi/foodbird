package com.sub.gen.enums;

import com.sub.gen.interfaces.StrategySelective;

/**
 * 代码形态
 * Created by yy111026 on 2017/2/6.
 */
public enum ReferenceForm implements StrategySelective {

    /* 定义态 */
    Define,
    /* 陈述态 */
    State,
    /* 参数态 */
    Param,
    /* 调用态 */
    Invoke,
    /* 调用态 */
    Variable;

    @Override
    public String key() {
        return getClass().getName();
    }

    @Override
    public Object value() {
        return this;
    }
}
