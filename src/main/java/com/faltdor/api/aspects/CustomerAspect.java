package com.faltdor.api.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerAspect {

	@Before("execution(* com.faltdor.api.services.CustomerService.getCustomerById(..))")
	public void getCustomerByIdAdvice() {
		System.out.println("Execute Advice on getCustomerById");
	}
	
	@Before("execution(* com.faltdor.api.services.CustomerService.set*(..))")
	public void getAllSetAdvices(JoinPoint joinPoint) {
		System.out.println("Excute advice on Service set Method: " + joinPoint.getSignature().getName());
	}
	
//	@Before("execution(* com.faltdor.api.services.CustomerService.*(..))")
//    public void advice() {
//		System.out.println("Execute Advice on getCustomerById");
//    }
	
	
}
