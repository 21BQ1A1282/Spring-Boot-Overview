package com.sai.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.springcoredemo.common.Coach;

@RestController
public class DemoController {
	
	//define a private field for the dependency
	private Coach mycoach;
	
	//define a constructor for dependency injection
	@Autowired
	public DemoController(Coach theCoach) {
		mycoach=theCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return mycoach.getDailyWorkout();
	}
}
