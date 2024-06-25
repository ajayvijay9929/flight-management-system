// Package declaration for the DAO (Data Access Object) layer
package com.aeroBlasters.flightManagementSystem.dao;

// Importing necessary Java and Spring framework classes
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; // Spring Data JPA repository for CRUD operations
import org.springframework.data.jpa.repository.Query; // Annotation to specify custom queries
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; // Annotation to enable JPA repositories
import org.springframework.data.repository.query.Param; // Annotation for named parameters in queries
import org.springframework.stereotype.Repository; // Annotation to indicate that the class provides the mechanism for storage, retrieval, update, delete operation on objects

import com.aeroBlasters.flightManagementSystem.bean.Airport; // Importing Airport bean class

// Annotation to indicate this interface as a Repository component in the persistence layer
@Repository
@EnableJpaRepositories // Enables JPA repositories. Generally used on configuration classes

// Interface extending JpaRepository for Airport entities, with String type
// primary key
public interface AirportRepository extends JpaRepository<Airport, String> {
	// Custom query to select all airport codes from the Airport entity
	@Query("select airportCode from Airport")
	public List<String> findAllAirportCodes();

	// Custom query to find an airport code by its location
	@Query("select airportCode from Airport where airportLocation= ?1")
	public String findAirportCodeByLocation(String airportLocation);
}
// Note: The use of positional parameters (?1) in queries is supported but named
// parameters (e.g., :location) could enhance readability and maintainability.