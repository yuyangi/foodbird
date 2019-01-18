package com.foodbird.generate.dynamic.annotations;

import com.foodbird.generate.dynamic.enums.FBActionType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 业务操作节点注解，完成一个业务操作的方法
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FBAction {

    /**
     * 功能ID
     */
    String id();

    /**
     * 功能名称
     */
    String name() default "";

    /**
     * 业务id
     */
    String[] serviceId() default "";

    /**
     * 是否可并行执行
     */
    boolean isParallel() default false;

    /**
     * 是否需要重试
     */
    boolean needRetry() default true;

    /**
     * 是否需要加锁
     */
    boolean needLock() default true;

    /**
     * 节点序号，有序情况下用来排序
     */
    int index() default 0;

    /**
     * 依赖的action
     */
    String[] dependencies() default "";

    /**
     * 操作类型
     *      FBActionType#NORMAL 普通处理操作
     *      FBActionType#CHECKER 校验操作；返回值必须是boolean型，false会终止执行
     *      FBActionType#ROUTER 路由操作；返回值必须是String类型，执行指定返回值节点的操作
     */
    FBActionType actionType() default FBActionType.NORMAL;

}
