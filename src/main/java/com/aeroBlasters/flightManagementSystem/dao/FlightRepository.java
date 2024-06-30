package com.aeroBlasters.flightManagementSystem.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.aeroBlasters.flightManagementSystem.bean.Flight;

/**
 * FlightRepository interface for accessing flight data.
 * It extends JpaRepository to leverage Spring Data JPA's capabilities for CRUD
 * operations and more.
 * This interface directly connects to the Flight entity.
 */
@Repository // Marks the interface as a Spring Data Repository
@EnableJpaRepositories // Enables JPA repositories. Usually placed on a configuration class, but here
                       // for simplicity.
public interface FlightRepository extends JpaRepository<Flight, Long> {

    /**
     * Custom query to find flights by their route ID.
     * Uses Spring Data JPA @Query annotation to define a JPQL (Java Persistence
     * Query Language) query.
     * 
     * @param routeId The ID of the route to find flights for.
     * @return A list of Flight entities that match the given route ID.
     */
    @Query("Select a from Flight a where routeId = ?1")
    public List<Flight> findFlightsByRouteId(Long routeId);
}