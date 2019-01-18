package com.foodbird.generate.dynamic.enums;

import java.util.Arrays;

public enum FBOperationType {

    CREATE("创建", "create"),
    READ("查询", "read"),
    UPDATE("更新", "update"),
    DELETE("删除", "delete"),
    PENDING("待定", "pending");

    private String name;
    private String code;

    FBOperationType(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public static FBOperationType typeOf(String type) {
        return Arrays.stream(values()).filter(t -> t.code.equals(type) || t.name.equals(type)).findFirst().orElse(null);
    }
}
