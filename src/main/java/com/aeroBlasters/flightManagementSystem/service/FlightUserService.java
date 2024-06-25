// Package declaration for the service layer
package com.aeroBlasters.flightManagementSystem.service;

// Importing Spring framework annotations and classes for dependency injection, service declaration, and user details handling
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Importing the flightUser bean class and FlightUserRepository interface
// flightUser represents the user entity, and FlightUserRepository is used for data access operations related to users
import com.aeroBlasters.flightManagementSystem.bean.flightUser;
import com.aeroBlasters.flightManagementSystem.dao.FlightUserRepository;

// Annotating this class as a Service to indicate it's part of the service layer and to enable Spring's component scanning
@Service
public class FlightUserService implements UserDetailsService {
	@Autowired
	private FlightUserRepository repository; // Injecting FlightUserRepository to interact with the user data

	private String type; // Variable to store user type (e.g., customer or admin)

	// Method to save user details into the database
	public void save(flightUser user) {
		repository.save(user);
	}

	// Getter method for the user type
	// This can be used to determine the type of pages to display (admin or
	// customer)
	public String getType() {
		return type;
	}

	// Overriding the loadUserByUsername method from UserDetailsService
	// This method is used by Spring Security to load user details based on the
	// username
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Retrieving the user from the repository
		// Throws NoSuchElementException if user is not found (when calling .get() on an
		// Optional)
		flightUser users = repository.findById(username).get();
		type = users.getType(); // Setting the user type based on the retrieved user details
		return users; // Returning the user details

	}

}