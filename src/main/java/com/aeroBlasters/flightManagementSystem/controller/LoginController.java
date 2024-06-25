// Package declaration for controller classes
package com.aeroBlasters.flightManagementSystem.controller;

// Importing necessary Spring framework and project-specific classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.aeroBlasters.flightManagementSystem.bean.flightUser;
import com.aeroBlasters.flightManagementSystem.service.FlightUserService;

// Annotation to denote this class as a Controller component in Spring MVC
@Controller
public class LoginController {

	// Injecting FlightUserService using Spring's dependency injection
	@Autowired
	private FlightUserService service;

	// Injecting BCryptPasswordEncoder for password encryption
	@Autowired
	private BCryptPasswordEncoder bCrypt;

	// Mapping HTTP GET requests to "/register" to this method
	@GetMapping("/register")
	public ModelAndView showUserRegisterPage() {
		// Creating a new instance of flightUser
		flightUser user = new flightUser();
		// Preparing the ModelAndView object with view name and model attribute
		ModelAndView mv = new ModelAndView("newUserEntry");
		mv.addObject("userRecord", user);
		return mv;
	}

	// Mapping HTTP GET requests to "/loginpage" to this method
	@GetMapping("/loginpage")
	public ModelAndView showloginPage() {
		// Directly returning the ModelAndView object with the view name
		return new ModelAndView("loginPage");
	}

	// Mapping HTTP GET requests to "/loginErrorPage" to this method
	@GetMapping("/loginErrorPage")
	public ModelAndView showloginErrorPage() {
		// Directly returning the ModelAndView object with the view name
		return new ModelAndView("loginErrorPage");
	}

	// Mapping HTTP GET requests to "/index" to this method
	@GetMapping("/index")
	public ModelAndView showIndexPage() {
		// Directly returning the ModelAndView object with the view name
		return new ModelAndView("index");
	}

	// Mapping HTTP POST requests to "/register" to this method
	@PostMapping("/register")
	public ModelAndView saveUserRegistrationPage(@ModelAttribute("userRecord") flightUser user) {
		// Encrypting the user's password
		String encodedPassword = bCrypt.encode(user.getPassword());
		// Creating a new instance of flightUser to save the encrypted password
		flightUser newUser = new flightUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(encodedPassword);
		newUser.setType(user.getType());
		// Saving the new user with encrypted password
		service.save(newUser);
		// Redirecting to the login page after successful registration
		return new ModelAndView("loginPage");
	}
}