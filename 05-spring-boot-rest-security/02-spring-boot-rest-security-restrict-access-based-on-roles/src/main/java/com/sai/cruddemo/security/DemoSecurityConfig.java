package com.sai.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(configurer ->
		            configurer 
		                    .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
		                    .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
		                    .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
		                    .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
		                    .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")        
		);
		
		// use HTTP Basic authentication
		http.httpBasic(Customizer.withDefaults());
		
		// disable cross site request forgery (csrf)
		// in general, not required for stateless REST APIs that use POST , PUT , DELETE and/or PATCH
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
	
	
	
	
}
