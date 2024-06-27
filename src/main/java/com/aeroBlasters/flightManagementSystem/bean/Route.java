package com.aeroBlasters.flightManagementSystem.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

// Entity annotation indicates that this class is an entity and is mapped to a database table
@Entity
public class Route {

	// Id annotation specifies the primary key of an entity
	@Id
	private Long routeId; // Unique identifier for the route
	private String sourceAirportCode; // Airport code of the source airport
	private String destinationAirportCode; // Airport code of the destination airport
	private Double fare; // Fare for the route

	// Default constructor
	public Route() {
		super();
	}

	// Constructor with parameters to initialize route details
	public Route(Long routeId, String sourceAirportCode, String destinationAirportCode, Double fare) {
		super();
		this.routeId = routeId;
		this.sourceAirportCode = sourceAirportCode;
		this.destinationAirportCode = destinationAirportCode;
		this.fare = fare;
	}

	// Getter for routeId
	public Long getRouteId() {
		return routeId;
	}

	// Setter for routeId
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	// Getter for sourceAirportCode
	public String getSourceAirportCode() {
		return sourceAirportCode;
	}

	// Setter for sourceAirportCode
	public void setSourceAirportCode(String sourceAirportCode) {
		this.sourceAirportCode = sourceAirportCode;
	}

	// Getter for destinationAirportCode
	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	// Setter for destinationAirportCode
	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}

	// Getter for fare
	public Double getFare() {
		return fare;
	}

	// Setter for fare
	public void setFare(Double fare) {
		this.fare = fare;
	}
}