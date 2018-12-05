package com.foodbird.generate.java.strategy.factory;

import com.foodbird.generate.java.codes.StrategySelective;
import com.foodbird.generate.java.strategy.ICodeGenerateStrategy;

/**
 * @author yy111026 on 2017/2/21.
 */
public interface ICodeGenerateStrategyFactory {

    ICodeGenerateStrategy create(StrategySelective selective);

}
