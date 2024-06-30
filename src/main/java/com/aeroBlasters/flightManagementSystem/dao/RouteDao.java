// Package declaration for the DAO (Data Access Object) layer
package com.aeroBlasters.flightManagementSystem.dao;

// Importing Java utility class for handling lists
import java.util.List;

// Importing Airport and Route bean classes from the flightManagementSystem.bean package
// These classes represent the data model for airports and routes in the system
import com.aeroBlasters.flightManagementSystem.bean.Airport;
import com.aeroBlasters.flightManagementSystem.bean.Route;

// Interface declaration for RouteDao
// This interface defines the contract for data access operations related to routes in the flight management system
public interface RouteDao {
   // Method to save a route object to the database
   public void save(Route route);

   // Method to retrieve all route objects from the database
   public List<Route> findAllRoutes();

   // Method to find a specific route by its ID
   public Route findRouteById(Long id);

   // Method to find a route ID based on its source and destination airports
   // Note: The method returns the ID of the route, not the route object itself
   public Long findRouteBySourceAndDestination(String source, String Destination, Double fare);

   // Method to generate a unique ID for a new route
   // This could be used to assign a unique identifier to a route before saving it
   // to the database
   public Long generateRouteId();

   public List<Long> findAllRoutesId();
}
// Note: The interface assumes the existence of an underlying mechanism to
// persist and retrieve Route objects, such as a database.