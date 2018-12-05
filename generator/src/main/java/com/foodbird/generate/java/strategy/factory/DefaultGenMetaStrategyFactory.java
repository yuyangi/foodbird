package com.foodbird.generate.java.strategy.factory;

import com.foodbird.generate.java.enums.MetaType;
import com.foodbird.generate.java.strategy.IGenMetaStrategy;
import com.foodbird.generate.java.strategy.meta.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yy111026
 * @date 2017/02/13
 */
public class DefaultGenMetaStrategyFactory implements IGenMetaStrategyFactory {

    private static DefaultGenMetaStrategyFactory instance = new DefaultGenMetaStrategyFactory();

    private static Map<MetaType, IGenMetaStrategy> cache = new ConcurrentHashMap<MetaType, IGenMetaStrategy>();
    static {
        cache.put(MetaType.Attribute, new AttributeCodeMetaStrategy());
        cache.put(MetaType.Class, new ClassCodeMetaStrategy());
        cache.put(MetaType.Method, new MethodCodeMetaStrategy());
        cache.put(MetaType.Reference, new ReferenceCodeMetaStrategy());
        cache.put(MetaType.Type, new DefaultCodeMetaStrategy());
        cache.put(MetaType.Parameter, new DefaultCodeMetaStrategy());
    }

    private DefaultGenMetaStrategyFactory() {

    }

    public static IGenMetaStrategyFactory getInstance() {
        return instance;
    }

    @Override
    public IGenMetaStrategy create(MetaType metaType) {
        return cache.get(metaType);
    }

}
