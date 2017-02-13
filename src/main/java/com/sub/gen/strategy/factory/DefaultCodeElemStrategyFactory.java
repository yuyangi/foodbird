package com.sub.gen.strategy.factory;

import com.sub.gen.enums.CodeElement;
import com.sub.gen.strategy.ICodeElemStrategy;
import com.sub.gen.strategy.elem.AttributeCodeStrategy;
import com.sub.gen.strategy.elem.ClassCodeStrategy;
import com.sub.gen.strategy.elem.DefaultCodeStrategy;
import com.sub.gen.strategy.elem.MethodCodeStrategy;
import com.sub.gen.strategy.elem.ReferenceCodeStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yy111026
 * @date 2017/02/13
 */
public class DefaultCodeElemStrategyFactory implements ICodeElemStrategyFactory {

    private static Map<CodeElement, ICodeElemStrategy> cache = new ConcurrentHashMap<CodeElement, ICodeElemStrategy>();
    static {
        cache.put(CodeElement.Attribute, new AttributeCodeStrategy());
        cache.put(CodeElement.Class, new ClassCodeStrategy());
        cache.put(CodeElement.Method, new MethodCodeStrategy());
        cache.put(CodeElement.Reference, new ReferenceCodeStrategy());
        cache.put(CodeElement.Type, new DefaultCodeStrategy());
        cache.put(CodeElement.Parameter, new DefaultCodeStrategy());
    }
    @Override
    public ICodeElemStrategy create(CodeElement codeElement) {
        return cache.get(codeElement);
    }

}
