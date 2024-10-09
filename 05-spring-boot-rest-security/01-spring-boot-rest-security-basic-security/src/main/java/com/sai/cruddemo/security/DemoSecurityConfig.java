package com.sai.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails sai = User.builder()
				.username("sai")
				.password("{noop}sai@123")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails yash = User.builder()
				.username("yash")
				.password("{noop}yash@456")
				.roles("EMPLOYEE","MANAGER")
				.build();
		
		UserDetails tarun = User.builder()
				.username("tarun")
				.password("{noop}tarun@789")
				.roles("EMPLOYEE","MANAGER","ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(sai, yash, tarun);
	}
}
