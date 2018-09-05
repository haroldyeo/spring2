package com.harold.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harold.aopdemo.dao.AccountDao;
import com.harold.aopdemo.dao.MembershipDao;

public class MainDemoApp {

	public static void main (String[] args) {
		// read spring config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		AccountDao accoutnDao = context.getBean(AccountDao.class);
		MembershipDao membershipDao = context.getBean(MembershipDao.class);
		
		// call buisness method
		Account acc = new Account();
		accoutnDao.addAccount(acc, true);
		accoutnDao.doWork();
		
		membershipDao.addSillyMember();
		membershipDao.goToSleep();
		
		
		// call getter and setter
		accoutnDao.setName("generale");
		accoutnDao.setServiceCode("007");
		
		accoutnDao.getName();
		accoutnDao.getServiceCode();
		
		// closse context
		context.close();
	}
}
