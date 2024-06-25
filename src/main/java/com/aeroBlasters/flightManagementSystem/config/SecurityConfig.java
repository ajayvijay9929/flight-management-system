package com.aeroBlasters.flightManagementSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.aeroBlasters.flightManagementSystem.service.FlightUserService;

// Configuration class to enable and configure Spring Security
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Autowire the FlightUserService to use it for authentication
	@Autowired
	private FlightUserService service;

	// Autowire the EncoderConfig to use it for password encoding
	@Autowired
	private EncoderConfig config;

	// Configures global settings for AuthenticationManagerBuilder including
	// userDetailsService and passwordEncoder
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(config.passwordEncoder());
	}

	// Configures web based security for specific http requests
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/register", "/submitsignup").permitAll() // Allows everyone to access register and
																		// submitsignup
				.anyRequest().authenticated() // All other requests require authentication
				.and()
				.formLogin()
				.loginPage("/loginpage") // Custom login page
				.failureUrl("/loginErrorPage") // Redirect to this page after login failure
				.loginProcessingUrl("/login") // URL to submit the username and password
				.permitAll() // Allow everyone to see the login page
				.and()
				.logout()
				.logoutSuccessUrl("/index"); // Redirect to this page after logout
	}
}