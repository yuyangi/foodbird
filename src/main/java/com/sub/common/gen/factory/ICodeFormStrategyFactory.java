package com.sub.common.gen.factory;

import com.sub.common.gen.enums.CodeForm;
import com.sub.common.gen.strategy.ICodeFormStrategy;

/**
 * Created by yy111026 on 2017/2/9.
 */
public interface ICodeFormStrategyFactory {

    ICodeFormStrategy create(CodeForm codeForm);

}
