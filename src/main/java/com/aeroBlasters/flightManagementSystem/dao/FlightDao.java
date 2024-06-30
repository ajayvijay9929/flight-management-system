package com.aeroBlasters.flightManagementSystem.dao;

import java.util.List;
import com.aeroBlasters.flightManagementSystem.bean.Flight;

/**
 * The FlightDao interface defines the contract for flight data access
 * operations.
 * It provides methods for saving, retrieving, and querying Flight entities.
 */
public interface FlightDao {

    /**
     * Saves a flight entity to the database.
     * This method can be used for both creating a new flight record or updating an
     * existing one.
     * 
     * @param flight The flight entity to be saved.
     */
    public void save(Flight flight);

    /**
     * Retrieves all flight entities from the database.
     * 
     * @return A list of all flights.
     */
    public List<Flight> findAllFlights();

    /**
     * Adds a new flight entity to the database.
     * This method is specifically intended for creating new flight records.
     * 
     * @param flight The new flight entity to be added.
     */
    public void addFlight(Flight flight);

    /**
     * Finds and retrieves a list of flights based on the route ID.
     * This method is useful for querying flights that operate on a specific route.
     * 
     * @param routeId The ID of the route for which flights are to be found.
     * @return A list of flights that operate on the specified route.
     */
    public List<Flight> findFlightsByRouteId(Long routeId);

}