package com.sai.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sai.springcoredemo.common.Coach;
import com.sai.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {
	
	@Bean("aquatic")
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
