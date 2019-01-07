package com.foodbird.generate.dynamic.enums;

public enum FBActionType {

    /**
     * 校验动作，返回false会停止业务处理
     */
    CHECKER,
    /**
     * 普通动作，执行业务逻辑
     */
    NORMAL,
    /**
     * 路由动作，根据逻辑指定下一个执行的目标动作
     */
    ROUTER,

}
