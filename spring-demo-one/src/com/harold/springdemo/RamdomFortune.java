package com.harold.springdemo;

import java.util.Random;

public class RamdomFortune implements FortuneService {

	@Override
	public String getFortune() {
		String[] fortunes = {"R1","R2", "R3"};
		Random r = new Random();
		return fortunes[r.nextInt(3)];
	}

}
