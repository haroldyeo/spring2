package com.harold.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	@Pointcut("execution(* com.harold.aopdemo.dao.*.* (..))") // all methods in a given package 
	public void forDaoPackage() {}
	
	@Before("forDaoPackage()") 
	public void beforeAddAccount() {
		
		System.out.println("#######  BEFORE ACCOUNT  ################  ");
	}
	
	@Before("forDaoPackage()")
	public void apiAnalytics() {
		System.out.println("-+-+-+-+  API ANALYTICS  -+-+-+-+-+-  ");
	}

}
