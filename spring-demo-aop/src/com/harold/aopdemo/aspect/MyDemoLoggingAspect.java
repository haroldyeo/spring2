package com.harold.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
//	@Before("execution(public void add*())")
	
//	@Before("execution(public void com.harold.aopdemo.AccountDao.addAccount())")
	
//	@Before("execution(String add*())")
	
//	@Before("execution(* add*(..))") 
	
	@Before("execution(* com.harold.aopdemo.dao.*.* (..))") // all methods in a given package 
	public void beforeAddAccount() {
		
		System.out.println("Executing @Before =======>   BEFORE ADD ACCOUNT =========");
	}

}
