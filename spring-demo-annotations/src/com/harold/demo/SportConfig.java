package com.harold.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.harold.demo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// define bean for fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	// define bean for swim coach and inject dependancy
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
