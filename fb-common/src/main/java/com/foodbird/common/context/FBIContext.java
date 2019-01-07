package com.foodbird.common.context;

import java.io.Serializable;

public interface FBIContext extends Serializable {

    Object get(String key);

    void put(String key, Object value);

    <T> T getByKey(String key, Class<T> type) throws Exception;

    <T> T getByType(Class<T> type);

}
