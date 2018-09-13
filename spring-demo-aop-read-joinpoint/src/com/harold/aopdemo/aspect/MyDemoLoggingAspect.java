package com.harold.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.util.GenericSignature.MethodTypeSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.harold.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	@Before("com.harold.aopdemo.aspect.HaroldAopExpressions.excludeGettersAndSetters()") 
	public void beforeAddAccount(JoinPoint theJoinPoint) {		
		System.out.println("#######  BEFORE Aspect call  ################  ");
	
	
	// display the method signature
	MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
	System.out.println("Method: " + methodSignature);
	
	// display the method argument
	
	
	// get args
	Object[] args = theJoinPoint.getArgs();
	
	// loop through args
	for(Object obj : args) {
		if(obj instanceof Account) {
			Account acc = (Account)obj;
			System.out.println("the account: "+acc.toString());
		}
	}
	
	}
}
