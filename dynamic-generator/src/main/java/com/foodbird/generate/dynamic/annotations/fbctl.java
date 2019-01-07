package com.foodbird.generate.dynamic.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Component
public @interface fbctl {
}
