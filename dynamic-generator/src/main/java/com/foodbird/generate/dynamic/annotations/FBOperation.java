package com.foodbird.generate.dynamic.annotations;

import com.foodbird.generate.dynamic.enums.FBOperationType;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

import static com.foodbird.generate.dynamic.enums.FBOperationType.PENDING;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FBOperation {

    @AliasFor("cn")
    String name();

    @AliasFor("en")
    String code() default "";

    @AliasFor("code")
    String en() default "";

    @AliasFor("name")
    String cn() default "";

    String[] alias() default {};

    FBOperationType operationType() default PENDING;

    Class<?> returnType() default Object.class;

}
