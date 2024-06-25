// Package declaration for the DAO (Data Access Object) layer
package com.aeroBlasters.flightManagementSystem.dao;

// Importing the Optional class from java.util package
// Optional is a container object which may or may not contain a non-null value
import java.util.Optional;

// Importing the JpaRepository interface from Spring Data JPA
// JpaRepository provides JPA related methods for standard data access layers in a repository
import org.springframework.data.jpa.repository.JpaRepository;

// Importing the flightUser class from the bean package
// flightUser is an entity class that represents the user data in the flight management system
import com.aeroBlasters.flightManagementSystem.bean.flightUser;

// Declaration of the FlightUserRepository interface
// This interface extends JpaRepository, linking the flightUser entity with its primary key type (String)
// It provides an abstraction layer to perform CRUD operations on flightUser entities
public interface FlightUserRepository extends JpaRepository<flightUser, String> {
	// Declaration of findByUsername method
	// This method signature defines a custom query to find a flightUser entity by
	// its username
	// It returns an Optional of flightUser, which will contain the flightUser if
	// found, or be empty if not
	Optional<flightUser> findByUsername(String username);

}
// Note: The use of Optional for the return type helps in handling cases where
// the user might not be found, thus avoiding null checks.