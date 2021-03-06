package cn.kevin.dataguru.nmea_server.definition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface SentenceDefinition {

	public String name() default "";
	
	int order() default 0;
	
	boolean isRequired() default true;
}
