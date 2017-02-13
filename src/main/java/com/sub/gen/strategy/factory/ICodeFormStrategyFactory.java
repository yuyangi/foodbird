package com.sub.gen.strategy.factory;

import com.sub.gen.enums.CodeForm;
import com.sub.gen.strategy.ICodeFormStrategy;

/**
 * Created by yy111026 on 2017/2/9.
 */
public interface ICodeFormStrategyFactory {

    ICodeFormStrategy create(CodeForm codeForm);

}
