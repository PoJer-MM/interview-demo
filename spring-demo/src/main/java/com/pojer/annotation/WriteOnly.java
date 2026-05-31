package com.pojer.annotation;

import java.lang.annotation.*;

/**
 * 写库注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WriteOnly {

}