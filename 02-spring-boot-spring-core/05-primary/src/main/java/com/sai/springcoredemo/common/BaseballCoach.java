package com.sai.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class BaseballCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "Spend 30 min in batting practice!";
	}

}
