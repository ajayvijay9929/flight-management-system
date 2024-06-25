package com.aeroBlasters.flightManagementSystem.bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

// Annotates this class as an entity to be managed by JPA in the database
@Entity
public class flightUser extends User {

	// Marks the username as the primary key for the entity
	@Id
	private String username;
	private String password;
	private String type;

	// Default constructor initializing with default values
	public flightUser() {
		super("abc", "pqr", new ArrayList<>());
	}

	// Constructor with parameters for user details and authorities
	public flightUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String username2, String password2, String type2) {
		super(username, password, authorities); // Calls the parent class constructor
		this.username = username2; // Sets the username
		this.password = password2; // Sets the password
		this.type = type2; // Sets the user type
	}

	// Getter for username
	public String getUsername() {
		return username;
	}

	// Setter for username
	public void setUsername(String username) {
		this.username = username;
	}

	// Getter for password
	public String getPassword() {
		return password;
	}

	// Setter for password
	public void setPassword(String password) {
		this.password = password;
	}

	// Getter for user type
	public String getType() {
		return type;
	}

	// Setter for user type
	public void setType(String type) {
		this.type = type;
	}

	// Overrides the toString method to print user details
	@Override
	public String toString() {
		return "flightUser [username=" + username + ", password=" + password + ", type=" + type + "]";
	}
}