package com.foodbird.generate.dynamic.annotations;

import com.foodbird.generate.dynamic.enums.FBPersistentType;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Service
public @interface FBProcess {

    /**
     * 节点名称
     */
    String name() default "";

    /**
     * 流程id
     */
    String id() default "";

    /**
     * 是否需要重试
     */
    boolean needRetry() default true;

    /**
     * 限流
     */
    int limitation() default -1;

    /**
     * 降级
     */
    int degradation() default -1;

    /**
     * 节点间是否有序
     */
    boolean ordered() default true;

    /**
     * 持久化类型
     */
    FBPersistentType persistentType() default FBPersistentType.DB;

}
