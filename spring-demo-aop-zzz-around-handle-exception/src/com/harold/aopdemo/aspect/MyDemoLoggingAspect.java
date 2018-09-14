package com.harold.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private static Logger LOGGER = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	@Around("execution(* com.harold.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proJointPoint) throws Throwable {
		
		// print method we advising on
		
		LOGGER.info("\n ###    Advice @Around execution ...   ###");
		LOGGER.info("Method on @After: " + proJointPoint.getSignature().toShortString());
		
		// begin timestamp
		long begin = System.currentTimeMillis();
		
		// execute method
		Object result = null;
		
		try {
			
			result = proJointPoint.proceed();
			
		} catch (Exception e) {

			LOGGER.warning(e.getMessage());
			
//			result = "Solution coming to you!!";
			
			// IF WE WANT TO RETHROW
			throw e;
		}
		
		
		// end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and complete
		long duration = end - begin;
		
		LOGGER.info("\n ===>  Duration: " + duration / 1000 + " seconds");
		
		return result;
	}
	
	
	@Before("com.harold.aopdemo.aspect.HaroldAopExpressions.excludeGettersAndSetters()") 
	public void beforeAddAccount(JoinPoint theJoinPoint) {		
		LOGGER.info("#######  BEFORE Aspect call  ################  ");
	
	
	// display the method signature
	MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
	LOGGER.info("Method: " + methodSignature);
	
	// display the method argument
	
	
	// get args
	Object[] args = theJoinPoint.getArgs();
	
	// loop through args
	for(Object obj : args) {
		if(obj instanceof Account) {
			Account acc = (Account)obj;
			LOGGER.info("the account: "+acc.toString());
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
		LOGGER.info("Method @AfterReturning: " + method);
		
		// print the result value
		LOGGER.info("---  result ---");
		LOGGER.info(result.toString());
			
			
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
		LOGGER.info("\n ***    Advice @AfterThrowing execution ...   ***");
		LOGGER.info("Method on @afterThrowing: " + joinPoint.getSignature().toShortString());
		LOGGER.info("the exception caught: " + exception);
	}
	
	
	// After finally
	@After("execution(* com.harold.aopdemo.dao.AccountDao.getAccounts(..))")
	public void aterFinallyMethod(JoinPoint joinPoint) {
		LOGGER.info("\n ###    Advice @After execution ...   ###");
		LOGGER.info("Method on @After: " + joinPoint.getSignature().toShortString());
	}
	
}
