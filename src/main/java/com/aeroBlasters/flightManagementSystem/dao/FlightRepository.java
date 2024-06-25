// Package declaration for the DAO (Data Access Object) layer
package com.aeroBlasters.flightManagementSystem.dao;

// Importing the JpaRepository interface from Spring Data JPA
// This interface simplifies data access operations by providing CRUD (Create, Read, Update, Delete) and pagination handling
import org.springframework.data.jpa.repository.JpaRepository;

// Importing the Flight entity class
// This class represents the flight data model in the application
import com.aeroBlasters.flightManagementSystem.bean.Flight;

// Declaration of the FlightRepository interface
// This interface extends JpaRepository, linking the Flight entity with its primary key type (Long)
// By extending JpaRepository, FlightRepository inherits methods for performing common persistence operations
public interface FlightRepository extends JpaRepository<Flight, Long> {
    // At this point, the interface does not declare any additional methods
    // Custom query methods can be added here as needed
}
// Note: The use of JpaRepository provides a powerful way to interact with the
// database without writing boilerplate code.