package com.eatmans.sms.anntation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author eatmans
 * @version 1.0
 * @date 2021/6/2
 */

/**
 * 权限注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface HasPermissions {
    String value();
}