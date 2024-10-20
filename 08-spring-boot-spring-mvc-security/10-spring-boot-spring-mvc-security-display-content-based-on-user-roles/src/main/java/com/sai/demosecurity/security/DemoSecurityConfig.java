package com.sai.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	        http.authorizeHttpRequests(configurer ->
	                        configurer
	                        .requestMatchers("/").hasRole("EMPLOYEE")
	                        .requestMatchers("/leaders/**").hasRole("MANAGER")
	                        .requestMatchers("/systems/**").hasRole("ADMIN")
	                        .anyRequest().authenticated()
	                )
	                .formLogin(form ->
	                        form
	                                .loginPage("/showMyLoginPage")
	                                .loginProcessingUrl("/authenticateTheUser")
	                                .permitAll()
	                )
	                .exceptionHandling(configurer -> 
	                        configurer
	                                .accessDeniedPage("/access-denied")
	                )
	                .logout(logout -> logout.permitAll()
	                );

	        return http.build();
	    }
}
