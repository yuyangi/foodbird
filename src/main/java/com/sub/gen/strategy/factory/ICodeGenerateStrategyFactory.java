package com.sub.gen.strategy.factory;

import com.sub.gen.codes.StrategySelective;
import com.sub.gen.strategy.ICodeGenerateStrategy;

/**
 * @author yy111026 on 2017/2/21.
 */
public interface ICodeGenerateStrategyFactory {

    ICodeGenerateStrategy create(StrategySelective selective);

}
