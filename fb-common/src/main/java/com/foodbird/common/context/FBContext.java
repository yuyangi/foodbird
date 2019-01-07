package com.foodbird.common.context;

import java.util.Map;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/28
 */
public class FBContext implements FBIContext {

    private Map<String, Class<?>> typeContext;
    private Map<Class<?>, Object> objectContext;

    @Override
    public Object get(String key) {
        return objectContext.get(typeContext.get(key));
    }

    @Override
    public void put(String key, Object value) {
        typeContext.put(key, value.getClass());
        objectContext.put(value.getClass(), value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getByKey(String key, Class<T> type) {
        Class<?> exitsType = typeContext.get(key);
        if (type.isAssignableFrom(exitsType)) {
            return (T) objectContext.get(exitsType);
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getByType(Class<T> type) {
        Object o = objectContext.get(type);
        if (type.isAssignableFrom(o.getClass())) {
            return (T) o;
        }
        return null;
    }
}
