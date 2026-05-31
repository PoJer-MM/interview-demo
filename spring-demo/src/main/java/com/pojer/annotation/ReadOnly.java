package com.pojer.annotation;

import java.lang.annotation.*;

/**
 * 读库注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ReadOnly {

}