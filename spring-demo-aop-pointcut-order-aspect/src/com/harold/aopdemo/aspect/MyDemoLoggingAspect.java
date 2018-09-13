package com.harold.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	@Before("com.harold.aopdemo.aspect.HaroldAopExpressions.excludeGettersAndSetters()") 
	public void beforeAddAccount() {		
		System.out.println("#######  BEFORE Aspect call  ################  ");
	}
	

}
