package com.foodbird.generate.dynamic.annotations;

import org.springframework.core.annotation.AliasFor;

public @interface FBService {

    @AliasFor("cn")
    String name() default "";

    @AliasFor("en")
    String code() default "";

    @AliasFor("code")
    String en() default "";

    @AliasFor("name")
    String cn() default "";

}
