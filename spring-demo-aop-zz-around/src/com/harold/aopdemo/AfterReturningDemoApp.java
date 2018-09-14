package com.harold.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harold.aopdemo.dao.AccountDao;

public class AfterReturningDemoApp {

	public static void main (String[] args) {
		// read spring config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		AccountDao accoutnDao = context.getBean(AccountDao.class);
		
		// call  method to find accounts
		List<Account> myAccounts = accoutnDao.getAccounts(false);
		
		// display accounts
		System.out.println("\n\n Main program: AfterReturning ");
		System.out.println("----");
		System.out.println(myAccounts);
		System.out.println("\n");
		
		
		// closse context
		context.close();
	}
}
