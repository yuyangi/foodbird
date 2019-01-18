package com.foodbird.generate.dynamic.annotations;

import com.foodbird.generate.dynamic.enums.FBOperationType;
import org.springframework.core.annotation.AliasFor;

import static com.foodbird.generate.dynamic.enums.FBOperationType.PENDING;

public @interface FBOperation {

    String name();

    String code() default "";

    @AliasFor("code")
    String en() default "";

    @AliasFor("name")
    String cn() default "";

    String[] alias() default {};

    FBOperationType operationType() default PENDING;

    Class<?> returnType() default Object.class;

}
