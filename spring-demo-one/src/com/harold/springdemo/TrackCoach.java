package com.harold.springdemo;

public class TrackCoach implements Coach {
	
	// define the fied for dependancy
		private FortuneService fortuneService;
		
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it: "+ fortuneService.getFortune() ;
	}
	
	// init method
	public void startup() {
		System.out.println("Started trackCoach");
	}
	
	// destroy method
	public void destroy() {
		System.out.println("Destroyed trackCoach");
	}
}
