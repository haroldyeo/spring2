package com.harold.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	@Pointcut("execution(* com.harold.aopdemo.dao.*.*(..))")  
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.harold.aopdemo.dao.*.get*(..))")  
	public void getter() {}
	
	@Pointcut("execution(* com.harold.aopdemo.dao.*.set*(..))")  
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")  
	public void excludeGettersAndSetters() {}
	
	@Before("excludeGettersAndSetters()") 
	public void beforeAddAccount() {		
		System.out.println("#######  BEFORE Aspect call  ################  ");
	}
	

}
