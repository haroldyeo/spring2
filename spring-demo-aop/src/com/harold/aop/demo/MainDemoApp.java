package com.harold.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harold.aopdemo.dao.AccountDao;

public class MainDemoApp {

	public static void main (String[] args) {
		// read spring config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		AccountDao accoutnDao = context.getBean(AccountDao.class);
		
		// call buisness method
		accoutnDao.addAccount();
		
		// closse context
		context.close();
	}
}
