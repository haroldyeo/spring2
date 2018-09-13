package com.harold.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
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
	
	
	// Add an after returning
	@AfterReturning(
			pointcut = "execution(* com.harold.aopdemo.dao.AccountDao.getAccounts(..))",
			returning = "result"
			)
	public void addAfterRetuning(JoinPoint joinPoint, List<Account> result) {
		
		// print out the method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("Method @AfterReturning: " + method);
		
		// print the result value
		System.out.println("---  result ---");
		System.out.println(result);
			
			
		// DATA POST PROCESSING
		convertAccountNamesToUpperCase(result);
	}


	private void convertAccountNamesToUpperCase(List<Account> result) {
		for(Account acc : result) {
			acc.setName(acc.getName().toUpperCase());
		}
		
	}
	
	
	
	// After throwing
	@AfterThrowing(pointcut = "execution(* com.harold.aopdemo.dao.AccountDao.getAccounts(..))",throwing = "exception")
	public void afterThrowingMethod(JoinPoint joinPoint, Throwable exception) {
		System.out.println("\n ***    Advice @AfterThrowing execution ...   ***");
		System.out.println("Method on @afterThrowing: " + joinPoint.getSignature().toShortString());
		System.out.println("the exception caught: " + exception);
	}
	
	
	// After finally
	@After("execution(* com.harold.aopdemo.dao.AccountDao.getAccounts(..))")
	public void aterFinallyMethod(JoinPoint joinPoint) {
		System.out.println("\n ###    Advice @After execution ...   ###");
		System.out.println("Method on @After: " + joinPoint.getSignature().toShortString());
	}
	
}
