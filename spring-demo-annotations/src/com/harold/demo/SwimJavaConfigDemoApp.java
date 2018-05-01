package com.harold.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		System.out.println("application context set");
		
		// get bean from container
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		
		// call method
		System.out.println(coach.getDaiyFortune());
		System.out.println(coach.getDaiyWorkout());
		
		System.out.println("Email: "+coach.getEmail());
		System.out.println("Team: "+coach.getTeam());
		
		
		// close context
			context.close();
	}

}
