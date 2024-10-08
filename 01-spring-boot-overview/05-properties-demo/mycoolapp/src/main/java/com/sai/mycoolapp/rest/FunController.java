package com.sai.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {
	
	// inject properties for: coach.name and team.name
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	// expose new endpoint for "teaminfo"
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach : "+ coachName +  " , TeamName : "+ teamName;
	}
	

	// expose "/" that return "Hello World"

	@GetMapping("/")
	public String sayhello() {
		return "Hello World";
	}

	//expose a new endpoint for "workout"

	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}

	//expose a new endpoint for "fortune"

	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day.";
	}
}
