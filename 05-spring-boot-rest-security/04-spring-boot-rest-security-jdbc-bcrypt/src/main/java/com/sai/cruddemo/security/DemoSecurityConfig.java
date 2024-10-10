package com.sai.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	// add support for JDBC... no more hardcoded users
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		return new JdbcUserDetailsManager(dataSource);
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


	/*
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {

		UserDetails sai = User.builder()
				.username("sai")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();

		UserDetails yash = User.builder()
				.username("yash")
				.password("{noop}test123")
				.roles("EMPLOYEE","MANAGER")
				.build();

		UserDetails tarun = User.builder()
				.username("tarun")
				.password("{noop}test123")
				.roles("EMPLOYEE","MANAGER","ADMIN")
				.build();

		return new InMemoryUserDetailsManager(sai, yash, tarun);
	}
	 */

}
