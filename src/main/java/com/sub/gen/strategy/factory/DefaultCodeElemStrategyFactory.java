package com.sub.gen.strategy.factory;

import com.sub.gen.enums.CodeElement;
import com.sub.gen.strategy.ICodeElemStrategy;
import com.sub.gen.strategy.elem.AttributeCodeStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yy111026 on 2017/2/13.
 *
 * @author yy111026
 * @date 2017/02/13
 */
public class DefaultCodeElemStrategyFactory implements ICodeElemStrategyFactory {

    private static Map<CodeElement, ICodeElemStrategy> cache = new ConcurrentHashMap<CodeElement, ICodeElemStrategy>();
    static {
        cache.put(CodeElement.Attribute, new AttributeCodeStrategy());
    }
    @Override
    public ICodeElemStrategy create() {
        return null;
    }

}
