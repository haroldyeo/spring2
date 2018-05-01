package com.harold.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String email;
	
	private String team;
	
	public CricketCoach() {
		System.out.println("No argument constructor called");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Setter fortuneService called");
		this.fortuneService = fortuneService;
	}
		
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	public void setEmail(String email) {
		System.out.println("Email setter called");
		this.email = email;
	}

	public void setTeam(String team) {
		System.out.println("Team setter called");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Practise fast bowling";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	

}
