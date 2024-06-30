package com.aeroBlasters.flightManagementSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.aeroBlasters.flightManagementSystem.bean.Flight;

/**
 * Implementation of the FlightDao interface.
 * This class provides concrete implementations for the data access methods
 * defined in FlightDao.
 * It uses Spring's @Service and @Repository annotations to denote a service
 * layer component and a data access object respectively.
 */
@Service
@Repository
public class FlightDaoImpl implements FlightDao {
    // Injects the FlightRepository to interact with the database.
    @Autowired
    private FlightRepository repository;

    /**
     * Saves a flight entity to the database.
     * This method can handle both new entities and existing ones (for updates).
     * 
     * @param flight The flight entity to be saved.
     */
    @Override
    public void save(Flight flight) {
        repository.save(flight);
    }

    /**
     * Retrieves a list of flights based on the route ID.
     * This method demonstrates how to perform custom queries beyond basic CRUD
     * operations.
     * 
     * @param routeId The ID of the route for which flights are to be retrieved.
     * @return A list of flights that belong to the specified route.
     */
    @Override
    public List<Flight> findFlightsByRouteId(Long routeId) {
        return repository.findFlightsByRouteId(routeId);
    }

    /**
     * Retrieves all flight entities from the database.
     * This method leverages the JpaRepository's findAll method.
     * 
     * @return A list of all flights in the database.
     */
    @Override
    public List<Flight> findAllFlights() {
        // TODO: Implement method functionality or remove if not needed.
        return repository.findAll();
    }

    /**
     * Adds a new flight entity to the database.
     * This method is intended for creating new flight records.
     * 
     * @param flight The new flight entity to be added.
     */
    @Override
    public void addFlight(Flight flight) {
        // TODO: Implement method functionality or remove if not needed.
    }

}