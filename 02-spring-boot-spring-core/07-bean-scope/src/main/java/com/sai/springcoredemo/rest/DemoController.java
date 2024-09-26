package com.sai.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.springcoredemo.common.Coach;

@RestController
public class DemoController {
	
	//define a private field for the dependency
	private Coach mycoach;
	private Coach anothercoach;
	//define a constructor for dependency injection
	@Autowired
	public DemoController( 
			               @Qualifier("cricketCoach") Coach theCoach,
			               @Qualifier("cricketCoach") Coach theanotherCoach ) {
		System.out.println("In constructor:"+ getClass().getSimpleName());
		mycoach=theCoach;
		anothercoach=theanotherCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return mycoach.getDailyWorkout();
	}
	
	@GetMapping("/check")
	public String check() {
		return "comparing beans: mycoach == anothercoach ," + (mycoach==anothercoach);
	}
}
