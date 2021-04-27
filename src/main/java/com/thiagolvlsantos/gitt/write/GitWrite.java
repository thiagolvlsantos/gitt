package com.thiagolvlsantos.gitt.write;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GitWrite {

	String value() default "";

	boolean watcher() default true;

	GitWriteDir[] values() default {};
}
