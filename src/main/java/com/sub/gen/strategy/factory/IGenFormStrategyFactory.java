package com.sub.gen.strategy.factory;

import com.sub.gen.enums.CodeForm;
import com.sub.gen.strategy.IGenFormStrategy;

/**
 * @author yy111026 on 2017/2/9.
 */
public interface IGenFormStrategyFactory {

    IGenFormStrategy create(CodeForm codeForm);

}
