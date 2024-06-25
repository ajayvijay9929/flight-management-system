package com.aeroBlasters.flightManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Marks this class as a configuration class for Spring's context
@Configuration
public class EncoderConfig {
  // Declares a bean for PasswordEncoder to be managed by Spring's container
  @Bean
  PasswordEncoder passwordEncoder() {
    // Returns an instance of BCryptPasswordEncoder, a password encoder that uses
    // the BCrypt strong hashing function
    return new BCryptPasswordEncoder();
  }
}