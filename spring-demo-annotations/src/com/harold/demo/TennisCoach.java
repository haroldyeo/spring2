package com.harold.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("ramdomFortuneService")
	private FortuneService fortuneService;


	// define a defaut constructor
	public TennisCoach() {
		System.out.println("Tennis coach: default constructor");
	}
	
	
	@Override
	public String getDaiyWorkout() {
		return "Practice your backend volley";
	}

	@Override
	public String getDaiyFortune() {
		return fortuneService.getFortune();
	}

}
