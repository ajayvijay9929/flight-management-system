package com.aeroBlasters.flightManagementSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.aeroBlasters.flightManagementSystem.bean.Airport;
import com.aeroBlasters.flightManagementSystem.bean.Route;
import com.aeroBlasters.flightManagementSystem.dao.AirportDao;
import com.aeroBlasters.flightManagementSystem.dao.RouteDao;

// Controller class for handling airport-related web requests
@RestController
public class AirportController {

	// Injecting the RouteDao bean to interact with route data
	@Autowired
	private RouteDao routeDao;

	// Injecting the AirportDao bean to interact with airport data
	@Autowired
	private AirportDao airportDao;

	// Handler method to display the index page
	@GetMapping("/i")
	public ModelAndView showIndePage() {
		return new ModelAndView("index_2");
	}

	// Handler method to display the airport entry form
	@GetMapping("/airport")
	public ModelAndView showAirportEntryPage() {
		Airport airport = new Airport();
		ModelAndView mv = new ModelAndView("airportAdd");
		mv.addObject("airport_data", airport);
		return mv;
	}

	// Handler method to process the submission of the airport entry form
	@PostMapping("/airport")
	public ModelAndView saveAirport(@ModelAttribute("airport_data") Airport airport) {
		// Convert airport code and location to uppercase before saving
		String str = airport.getAirportCode().toUpperCase();
		airport.setAirportCode(str);
		String stg = airport.getAirportLocation().toUpperCase();
		airport.setAirportLocation(stg);

		// Save the airport data
		airportDao.addAirport(airport);
		return new ModelAndView("index_2");
	}

	// Handler method to display all airports
	@GetMapping("/airports")
	public ModelAndView showAirport() {
		List<Airport> airportList = airportDao.showAllAirports();
		ModelAndView mv = new ModelAndView("airportAll");
		mv.addObject("airportList", airportList);
		return mv;
	}

	// Handler method to display a form for selecting an airport
	@GetMapping("/airport-select")
	public ModelAndView showSelectedOne() {
		List<String> codeList = airportDao.findAllAirportCodes();
		ModelAndView mv = new ModelAndView("airportSelected");
		mv.addObject("codeList", codeList);
		return mv;
	}

	// Handler method to display the selected airport's details
	@PostMapping("/airport-select")
	public ModelAndView selectedAirport(@RequestParam("airport-code") String id) {
		Airport airport = airportDao.showAirport(id);
		ModelAndView mv = new ModelAndView("airportDisplay");
		mv.addObject("airport", airport);
		return mv;
	}
}