package com.harold.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		System.out.println("application context set");
		
		// get bean from container
		Coach coach = context.getBean("tennisCoach", Coach.class);
		
		// call method
		System.out.println(coach.getDaiyFortune());
		System.out.println(coach.getDaiyWorkout());
		
		// close context
			context.close();
	}

}
