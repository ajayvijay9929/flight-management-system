// Package declaration aligning with project structure
package com.aeroBlasters.flightManagementSystem.dao;

// Importing necessary Java and Spring framework classes
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository; // Annotation to indicate DAO component in the persistence layer
import org.springframework.stereotype.Service; // Incorrect use of Service annotation, should be removed as this class is a Repository
import com.aeroBlasters.flightManagementSystem.bean.Airport; // Importing Airport bean class for airport operations
import com.aeroBlasters.flightManagementSystem.dao.AirportDao; // Importing AirportDao interface for implementation

// Annotation to indicate this class as a Repository component
@Repository
@Service // Incorrect annotation, should be removed as this class is not a service
public class AirportDaoImpl implements AirportDao {
	@Autowired // Autowiring feature of spring framework for dependency injection
	private AirportRepository repository; // Injecting AirportRepository for database operations

	@Override // Overriding addAirport method from AirportDao interface
	public void addAirport(Airport airport) {
		repository.save(airport); // Saving airport object to the database
	}

	@Override // Overriding showAllAirports method from AirportDao interface
	public List<Airport> showAllAirports() {
		return repository.findAll(); // Fetching all airport records from the database
	}

	@Override // Overriding showAirport method from AirportDao interface
	public Airport showAirport(String id) {
		// Fetching airport by ID. Note: .get() without checking .isPresent() can lead
		// to NoSuchElementException
		return repository.findById(id).get();
	}

	@Override // Overriding findAllAirportCodes method from AirportDao interface
	public List<String> findAllAirportCodes() {
		// Fetching all airport codes from the database
		return repository.findAllAirportCodes();
	}

	@Override // Overriding findAirportCodeByLocation from AirportDao interface
	public String findAirportCodeByLocation(String airportLocation) {
		// Fetching airport code by location
		return repository.findAirportCodeByLocation(airportLocation);
	}
}
// Note: The use of .get() on Optional without isPresent() check is risky and
// can lead to runtime exceptions if the value is not present.