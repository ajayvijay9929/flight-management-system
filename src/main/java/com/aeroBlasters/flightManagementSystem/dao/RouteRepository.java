// Package declaration for the DAO (Data Access Object) layer
package com.aeroBlasters.flightManagementSystem.dao;

// Importing Java utility class for handling lists
import java.util.List;

// Importing Spring Data JPA repository interface and Query annotation for custom queries
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// Importing the Route bean class from the flightManagementSystem.bean package
// This class represents the data model for routes in the flight management system
import com.aeroBlasters.flightManagementSystem.bean.Route;

// Declaration of the RouteRepository interface extending JpaRepository
// This interface provides an abstraction layer for CRUD operations and custom queries on Route entities
public interface RouteRepository extends JpaRepository<Route, Long> {

	// Custom query to find the highest route ID in the Route table
	// This method is useful for generating new route IDs sequentially
	@Query("select max(routeId) from Route")
	public Long findLastRouteId();

	// Custom query to find a route by its source and destination airport codes
	// This method returns the route ID matching the given source and destination
	@Query("select routeId from Route where sourceAirportCode = ?1 And destinationAirportCode= ?2 And fare= ?3")
	public Long findRouteBySourceAndDestination(String sourceAirportCode, String destinationAirportCode, Double fare);

}
// Note: The use of positional parameters (?1, ?2) in custom queries could be
// replaced with named parameters for better readability.