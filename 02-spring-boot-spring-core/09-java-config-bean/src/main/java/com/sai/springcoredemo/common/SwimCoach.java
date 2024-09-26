package com.sai.springcoredemo.common;


public class SwimCoach implements Coach{
	
	public SwimCoach() {
		System.out.println("In Constructor:"+getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim 1000m as a wrap up" ;
	}

}
