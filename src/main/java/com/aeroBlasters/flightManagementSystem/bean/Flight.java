package com.aeroBlasters.flightManagementSystem.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Flight class represents the flight entity with details about each flight.
 * It is mapped to a database table using JPA annotations.
 */
@Entity
public class Flight {
	@Id
	private Long flightNumber; // Unique identifier for the flight, acts as the primary key.
	private String carrierName; // The name of the airline operating the flight.
	private Long routeId; // Identifier for the specific route the flight takes.
	private Integer seatCapacity; // The total number of seats available on the flight.
	private String departure; // The scheduled departure time of the flight.
	private String arrival; // The scheduled arrival time of the flight.

	/**
	 * Default constructor for JPA.
	 */
	public Flight() {
		super();
	}

	/**
	 * Constructor with parameters to initialize a Flight object.
	 * 
	 * @param flightNumber The unique identifier for the flight.
	 * @param carrierName  The name of the airline operating the flight.
	 * @param routeId      The identifier for the flight's route.
	 * @param seatCapacity The total number of seats available.
	 * @param departure    The scheduled departure time.
	 * @param arrival      The scheduled arrival time.
	 */
	public Flight(Long flightNumber, String carrierName, Long routeId, Integer seatCapacity, String departure,
			String arrival) {
		super();
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.routeId = routeId;
		this.seatCapacity = seatCapacity;
		this.departure = departure;
		this.arrival = arrival;
	}

	// Getters and setters for each field with straightforward documentation.
	public Long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public Integer getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(Integer seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
}