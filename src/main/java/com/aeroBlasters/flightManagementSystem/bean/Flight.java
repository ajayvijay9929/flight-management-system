package com.aeroBlasters.flightManagementSystem.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

// Entity annotation indicates that this class is an entity and is mapped to a database table
@Entity
public class Flight {
	// Id annotation specifies the primary key of an entity
	@Id
	private Long flight_number; // Unique identifier for each flight
	private String carrier_name; // Name of the airline carrier
	private Integer seat_capacity; // Number of seats available on the flight
	private Long routeId; // Identifier for the flight route
	private String arrival; // Arrival time of the flight
	private String departure; // Departure time of the flight

	// Getter for flight number
	public Long getFlight_number() {
		return flight_number;
	}

	// Setter for flight number
	public void setFlight_number(Long flight_number) {
		this.flight_number = flight_number;
	}

	// Getter for carrier name
	public String getCarrier_name() {
		return carrier_name;
	}

	// Setter for carrier name
	public void setCarrier_name(String carrier_name) {
		this.carrier_name = carrier_name;
	}

	// Getter for seat capacity
	public int getSeat_capacity() {
		return seat_capacity;
	}

	// Setter for seat capacity
	public void setSeat_capacity(int seat_capacity) {
		this.seat_capacity = seat_capacity;
	}
}