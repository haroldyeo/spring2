package com.harold.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoClass {

	public static void main(String[] args) {
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("application context set");
		
		// get bean from container
		Coach coach = context.getBean("tennisCoach", Coach.class);
		Coach coach2 = context.getBean("tennisCoach", Coach.class);
		
		// call method
		System.out.println(coach);
		System.out.println(coach2);
		
		// close context
			context.close();
	}

}
