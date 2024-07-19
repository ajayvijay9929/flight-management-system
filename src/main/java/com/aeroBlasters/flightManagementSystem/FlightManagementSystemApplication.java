package com.aeroBlasters.flightManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Flight Management System application.
 * 
 * This class bootstraps the Spring Boot application using the
 * {@link SpringApplication#run} method.
 */
@SpringBootApplication
public class FlightManagementSystemApplication {

	/**
	 * Main method to start the Flight Management System application.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(FlightManagementSystemApplication.class, args);
	}
}
