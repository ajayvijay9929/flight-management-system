// Package declaration for the DAO (Data Access Object) layer
package com.aeroBlasters.flightManagementSystem.dao;

// Importing Java utility class for handling lists
import java.util.*;

// Importing Spring framework annotations for dependency injection and component declaration
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service; // Incorrect use of Service annotation, should be removed as this class is a Repository

// Importing the Route bean class from the flightManagementSystem.bean package
// This class represents the data model for routes in the flight management system
import com.aeroBlasters.flightManagementSystem.bean.Route;

// Incorrect use of both @Service and @Repository annotations; should only use @Repository for DAO implementations
@Service
@Repository
public class RouteDaoImpl implements RouteDao {
	@Autowired
	private RouteRepository repository; // Injecting RouteRepository to interact with the database

	@Override
	public void save(Route route) {
		repository.save(route); // Saving a route object to the database
	}

	@Override
	public List<Route> findAllRoutes() {
		return repository.findAll(); // Retrieving all route objects from the database
	}

	@Override
	public Route findRouteById(Long id) {
		return repository.findById(id).get(); // Retrieving a route by its ID, potential NoSuchElementException if ID
												// not found
	}

	@Override
	public Long findRouteBySourceAndDestination(String source, String destination, Double fare) {
		return repository.findRouteBySourceAndDestination(source, destination, fare); // Finding a route ID by source
																						// and destination
	}

	@Override
	public Long generateRouteId() {
		Long val = repository.findLastRouteId(); // Retrieving the last route ID from the database
		if (val == null)
			val = 101L; // Setting initial value if no routes are found
		else
			val = val + 1; // Incrementing the last route ID to generate a new ID
		return val;
	}

	@Override
	public List<Long> findAllRoutesId() {
		return repository.findAllRoutesId(); // Retrieving all route IDs from the database
	}

}