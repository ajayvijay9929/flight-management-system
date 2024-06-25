// Package declaration for organizing controller classes
package com.aeroBlasters.flightManagementSystem.controller;

// Importing necessary Java and Spring framework classes
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// Importing project-specific classes for Route and DAOs
import com.aeroBlasters.flightManagementSystem.bean.Route;
import com.aeroBlasters.flightManagementSystem.dao.AirportDao;
import com.aeroBlasters.flightManagementSystem.dao.RouteDao;
import com.aeroBlasters.flightManagementSystem.service.RouteService;

// Annotation to declare this class as a REST controller
@RestController
public class RouteController {

	// Autowiring to inject RouteDao, RouteService, and AirportDao beans
	// automatically
	@Autowired
	private RouteDao routeDao;
	@Autowired
	private RouteService routeService;
	@Autowired
	private AirportDao airportDao;

	// Handler method for GET request to display the route entry page
	@GetMapping("/routeEntryPage")
	public ModelAndView showRouteEntryPage() {
		// Generating a new route ID
		Long newRouteId = routeDao.generateRouteId();
		// Creating a new Route object and setting its ID
		Route route = new Route();
		route.setRouteId(newRouteId);
		// Preparing the ModelAndView with the view name and the route object
		ModelAndView mv = new ModelAndView("routeEntryPage");
		mv.addObject("routeRecord", route);
		return mv;
	}

	// Handler method for POST request to save route details
	@PostMapping("/route")
	public ModelAndView saveRoutes(@ModelAttribute("routeRecord") Route route1) {
		// Converting airport codes to uppercase
		String source = route1.getSourceAirportCode().toUpperCase();
		String destination = route1.getDestinationAirportCode().toUpperCase();
		route1.setSourceAirportCode(source);
		route1.setDestinationAirportCode(destination);
		// Finding airport codes by location
		String sourceCode = airportDao.findAirportCodeByLocation(route1.getSourceAirportCode());
		String destinationCode = airportDao.findAirportCodeByLocation(route1.getDestinationAirportCode());
		route1.setSourceAirportCode(sourceCode);
		route1.setDestinationAirportCode(destinationCode);
		// Creating a return route and saving both routes
		Route route2 = routeService.createReturnRoute(route1);
		routeDao.save(route1);
		routeDao.save(route2);
		// Redirecting to the index page after saving
		return new ModelAndView("index_2");
	}

	// Handler method for GET request to display all routes
	@GetMapping("/routes")
	public ModelAndView showRouteReportPage() {
		// Retrieving all routes from the database
		List<Route> routeList = routeDao.findAllRoutes();
		// Preparing the ModelAndView with the view name and the list of routes
		ModelAndView mv = new ModelAndView("routeReportPage");
		mv.addObject("routeList", routeList);
		return mv;
	}

}