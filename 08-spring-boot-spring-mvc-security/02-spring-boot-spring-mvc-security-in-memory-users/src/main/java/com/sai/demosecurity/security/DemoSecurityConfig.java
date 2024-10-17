package com.sai.demosecurity.security;

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
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails siva = User.builder()
				.username("siva")
				.password("{noop}test123")
				.roles("EMPLOYEE","MANAGER")
				.build();
		
		UserDetails tarun = User.builder()
				.username("tarun")
				.password("{noop}test123")
				.roles("EMPLOYEE","MANAGER","ADMIN")
				.build();
		return new InMemoryUserDetailsManager(sai,siva,tarun);
	}
}
