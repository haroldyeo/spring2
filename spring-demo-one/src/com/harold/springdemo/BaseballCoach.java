package com.harold.springdemo;

public class BaseballCoach implements Coach {
	
	// define the fied for dependancy
	private FortuneService fortuneService;
	
	// define a constructor for dependancy injection	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minuutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortune service
		return fortuneService.getFortune();
	}
}
