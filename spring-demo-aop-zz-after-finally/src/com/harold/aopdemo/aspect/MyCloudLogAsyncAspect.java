package com.harold.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	@Before("com.harold.aopdemo.aspect.HaroldAopExpressions.excludeGettersAndSetters()") 
	public void logToAsync() {		
		System.out.println("#######  The Cloud one  ################  ");
	}
}
