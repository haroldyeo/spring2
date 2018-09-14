package com.harold.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harold.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main (String[] args) {
		// read spring config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		TrafficFortuneService fs = context.getBean(TrafficFortuneService.class);
		
		System.out.println("\n Main program");
		
		String data = fs.getFortune();
		
		System.out.println("\n My fortune is: " + data);
		
		// closse context
		context.close();
	}
}
