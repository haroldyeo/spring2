package com.harold.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	Logger LOGGER = Logger.getLogger(CRMLoggingAspect.class.getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.harold.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.harold.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.harold.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forAppFlow() {}
	
	
	// set up @Before
	
	@Before("forAppFlow()")
	public void beforeWork(JoinPoint joinPoint) {
		// display method called
		String method = joinPoint.getSignature().toShortString();
		LOGGER.info("====> in @Before; method called: "+method);
		
		// display arguments
		Object[] args = joinPoint.getArgs();
		
		for(Object arg : args) {
			LOGGER.info("Argument: "+arg);
		}
	}
		
	// set up @AfterReturning

	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "result"
			)
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		// display method called
		String method = joinPoint.getSignature().toShortString();
		LOGGER.info("====> in @AfterReturning; method called: "+method);
		
		// result
		LOGGER.info("======> Result: "+result.toString());
				
	}
}
