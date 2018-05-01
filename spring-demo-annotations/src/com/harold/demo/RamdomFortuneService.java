package com.harold.demo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RamdomFortuneService implements FortuneService {

	// create an array of strings
	private String[] data = {"F1","F2","F3"};
		
	
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		// pick one fortune
		int index = random.nextInt(data.length);
		return data[index];
	}

}
