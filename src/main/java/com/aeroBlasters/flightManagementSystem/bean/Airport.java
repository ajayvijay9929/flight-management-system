package com.aeroBlasters.flightManagementSystem.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

// Defines the Airport class as an entity for JPA to store in the database
@Entity
public class Airport {

	// Marks airportCode as the primary key of the Airport entity
	@Id
	private String airportCode;
	// Stores the location of the airport
	private String airportLocation;

	// Returns the airport code
	public String getAirportCode() {
		return airportCode;
	}

	// Sets the airport code
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	// Returns the location of the airport
	public String getAirportLocation() {
		return airportLocation;
	}

	// Sets the location of the airport
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
}