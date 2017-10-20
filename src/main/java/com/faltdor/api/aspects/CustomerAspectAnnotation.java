package com.faltdor.api.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerAspectAnnotation {
	
	@Before("@annotation(Loggable)")
	public void myAnnotationAdvice(){
		System.out.println("Execute Advice before Annotation @Loggable");
	}
}
