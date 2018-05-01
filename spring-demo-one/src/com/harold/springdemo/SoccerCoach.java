package com.harold.springdemo;

public class SoccerCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Shoot 25 penalties";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
