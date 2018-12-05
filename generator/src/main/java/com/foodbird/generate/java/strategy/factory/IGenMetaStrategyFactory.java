package com.foodbird.generate.java.strategy.factory;

import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.strategy.IGenMetaStrategy;

/**
 * Created by yy111026 on 2017/2/9.
 */
public interface IGenMetaStrategyFactory {

    IGenMetaStrategy create(MetaType metaType);

}

