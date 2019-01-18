package com.foodbird.generate.dynamic.annotations;

import com.foodbird.generate.dynamic.enums.FBOperationType;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FBEntity {

    String name();

    String code() default "";

    @AliasFor("code")
    String en() default "";

    @AliasFor("name")
    String cn() default "";

    FBOperationType[] defaultOperationTypes() default {FBOperationType.CREATE, FBOperationType.READ, FBOperationType.UPDATE, FBOperationType.DELETE};

}
