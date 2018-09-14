package com.harold.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harold.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger LOGGER = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main (String[] args) {
		// read spring config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		TrafficFortuneService fs = context.getBean(TrafficFortuneService.class);
		
		LOGGER.info("\n Main program");
		
		boolean tripWire = true;
		String data = fs.getFortune(tripWire);
		
		LOGGER.info("\n My fortune is: " + data);
		
		LOGGER.info("\n Finished");
		// closse context
		context.close();
	}
}
