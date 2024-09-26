package com.sai.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.springcoredemo.common.Coach;

@RestController
public class DemoController {
	
	//define a private field for the dependency
	private Coach mycoach;
	
	//define a setter method  for dependency injection
	@Autowired
	public void setCoach(Coach thecoach) {
		mycoach = thecoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return mycoach.getDailyWorkout();
	}
}
