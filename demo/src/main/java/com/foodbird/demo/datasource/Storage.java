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
public class Storage<T extends IdName> {

    private Map<Integer, T> storage = Maps.newHashMap();

    public T read(int id) {
        return storage.get(id);
    }

    public void create(T t) {
        storage.put(t.getId(), t);
    }

    public void update(T t) {
        storage.put(t.getId(), t);
    }

    public void delete(T t) {
        storage.remove(t.getId());
    }

}
