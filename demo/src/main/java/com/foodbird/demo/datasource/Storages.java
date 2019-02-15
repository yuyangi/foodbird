package com.foodbird.demo.datasource;

import com.foodbird.demo.itf.IdName;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
@Component
public class Storages {

    private static Map<String, Storage<?>> storages = Maps.newHashMap();

    @SuppressWarnings("unchecked")
    public static <T extends IdName> Storage<T> getStorage(Class<T> type) {
        Storage<T> storage = (Storage<T>) storages.get(type.getName());
        if (storage == null) {
            putStorage(type);
        }
        return (Storage<T>) storages.get(type.getName());
    }

    @SuppressWarnings("unchecked")
    public static <T extends IdName> void putStorage(Class<T> type) {
        Storage<T> storage = (Storage<T>)storages.get(type.getName());
        if (storage == null) {
            storage = new Storage<>();
            storages.put(type.getName(), storage);
        }
    }

    public static Map<String, Storage<?>> all() {
        return storages;
    }

}
