package com.foodbird.demo.service;

import com.foodbird.demo.datasource.Storage;
import com.foodbird.demo.datasource.Storages;
import com.foodbird.demo.itf.IdName;
import com.foodbird.generate.dynamic.annotations.FBOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
@Component
public abstract class BaseService<T extends IdName> {

    private Storage<T> storage;

    public BaseService() {
        this.storage = Storages.getStorage(storageType());
    }

    public T read(int id) {
        return storage.read(id);
    }

    public void create(T t) {
        storage.create(t);
    }

    public void update(T t) {
        storage.update(t);
    }

    public void delete(T t) {
        storage.delete(t);
    }

    public abstract Class<T> storageType();

}
