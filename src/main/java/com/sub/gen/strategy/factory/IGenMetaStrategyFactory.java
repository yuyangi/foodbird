package com.sub.gen.strategy.factory;

import com.sub.gen.enums.MetaType;
import com.sub.gen.strategy.IGenMetaStrategy;

/**
 * Created by yy111026 on 2017/2/9.
 */
public interface IGenMetaStrategyFactory {

    IGenMetaStrategy create(MetaType metaType);

}

