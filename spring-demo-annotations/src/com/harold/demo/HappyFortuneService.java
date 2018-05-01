package com.harold.demo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		System.out.println("HappyFortuneService.getFortune()");
		return "Today is your lucky day";
	}

}
