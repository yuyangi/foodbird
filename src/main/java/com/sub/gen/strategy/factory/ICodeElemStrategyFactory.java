package com.sub.gen.strategy.factory;

import com.sub.gen.enums.CodeElement;
import com.sub.gen.strategy.ICodeElemStrategy;

/**
 * Created by yy111026 on 2017/2/9.
 */
public interface ICodeElemStrategyFactory {

    ICodeElemStrategy create(CodeElement codeElement);

}
