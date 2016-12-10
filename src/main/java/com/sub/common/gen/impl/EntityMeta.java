package com.sub.common.gen.impl;

/**
 * Created by yy111026 on 2016/12/9.
 */
public class EntityMeta {

    private String entityName;
    private String packages;

    public EntityMeta(String entityName, String packages) {
        this.entityName = entityName;
        this.packages = packages;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }
}
