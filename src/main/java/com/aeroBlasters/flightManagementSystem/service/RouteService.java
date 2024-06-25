package com.aeroBlasters.flightManagementSystem.service;

import org.springframework.stereotype.Service;

import com.aeroBlasters.flightManagementSystem.bean.Route;

// Annotating this class as a Service to indicate it's part of the service layer
// This class is responsible for business logic related to routes
@Service
public class RouteService {
	// Method to create a return route based on an existing route
	// It swaps the source and destination of the original route and increments the
	// route ID
	public Route createReturnRoute(Route route) {
		Long newId = route.getRouteId() + 1; // Incrementing the route ID for the return route
		String sourceCode = route.getDestinationAirportCode(); // Setting the original destination as the return route's
																// source
		String destinationCode = route.getSourceAirportCode(); // Setting the original source as the return route's
																// destination
		return new Route(newId, sourceCode, destinationCode); // Creating and returning the new Route object

	}

}