package com.sub.gen.codes;

/**
 * @author yy111026 on 2017/2/21.
 */
public interface StrategySelective extends IKeyValue {

    default String namespace() {
        return key();
    }

    default Object selective() {
        return value();
    }

}
