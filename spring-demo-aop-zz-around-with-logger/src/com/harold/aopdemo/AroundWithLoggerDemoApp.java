package com.harold.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harold.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger LOGGER = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main (String[] args) {
		// read spring config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		TrafficFortuneService fs = context.getBean(TrafficFortuneService.class);
		
		LOGGER.info("\n Main program");
		
		String data = fs.getFortune();
		
		LOGGER.info("\n My fortune is: " + data);
		
		// closse context
		context.close();
	}
}
