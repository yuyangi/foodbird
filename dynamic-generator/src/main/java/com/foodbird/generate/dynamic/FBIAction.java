package com.foodbird.generate.dynamic;

import com.foodbird.common.context.FBIContext;
import com.foodbird.generate.dynamic.enums.FBActionType;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/28
 */
public interface FBIAction<R> {

    /**
     * 操作内容
     * @param context 执行上下文
     * @return 节点功能返回值
     * @throws Throwable 业务异常
     */
    R doAction(FBIContext context) throws Throwable;

    /**
     * 功能ID
     */
    String id();

    /**
     * 功能名称
     */
    String name();

    /**
     * 业务id
     */
    String[] serviceId();

    /**
     * 是否可并行执行
     */
    boolean isParallel();

    /**
     * 是否需要重试
     */
    boolean needRetry();

    /**
     * 是否需要加锁
     */
    boolean needLock();

    /**
     * 节点序号，有序情况下用来排序
     */
    int index();

    /**
     * 依赖的action
     */
    String[] dependencies();

    /**
     * 操作类型
     *      FBActionType#NORMAL 普通处理操作
     *      FBActionType#CHECKER 校验操作；返回值必须是boolean型，false会终止执行
     *      FBActionType#ROUTER 路由操作；返回值必须是String类型，执行指定返回值节点的操作
     */
    FBActionType actionType();
}
