package com.harold.springbootdemo.myapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello world! the time on the server is : "+ LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a 5k";
	}

}
