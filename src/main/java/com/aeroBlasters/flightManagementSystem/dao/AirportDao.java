// Package declaration for Data Access Object (DAO) layer
package com.aeroBlasters.flightManagementSystem.dao;

// Importing necessary classes
import com.aeroBlasters.flightManagementSystem.bean.Airport; // Airport bean for airport-related operations
import java.util.List; // Java utility class for handling lists

// Interface definition for AirportDao
public interface AirportDao {
   // Method to add a new airport to the database
   public void addAirport(Airport airport);

   // Method to retrieve all airports from the database
   public List<Airport> showAllAirports();

   // Method to retrieve a specific airport by its ID
   public Airport showAirport(String id);

   // Method to retrieve all airport codes from the database
   public List<String> findAllAirportCodes();

   // Method to find an airport code based on its location
   public String findAirportCodeByLocation(String airportLocation);
}
// Note: The commented line suggests a possible implementation detail or related
// repository method.