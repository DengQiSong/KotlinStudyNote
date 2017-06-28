package com.dqs.kotlinnote.module.note;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：Denqs on 2017/6/1.
 */
@Retention(RetentionPolicy.RUNTIME)//只在源码中可用
@Target(ElementType.TYPE)
public @interface ClassInfo {
    String value();
}
