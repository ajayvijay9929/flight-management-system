package com.aeroBlasters.flightManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aeroBlasters.flightManagementSystem.bean.Flight;
import com.aeroBlasters.flightManagementSystem.bean.Route;
import com.aeroBlasters.flightManagementSystem.dao.AirportDao;
import com.aeroBlasters.flightManagementSystem.dao.FlightDao;
import com.aeroBlasters.flightManagementSystem.dao.RouteDao;
import com.aeroBlasters.flightManagementSystem.exception.FlightException;
import com.aeroBlasters.flightManagementSystem.exception.RouteException;
import com.aeroBlasters.flightManagementSystem.service.FlightService;
import com.aeroBlasters.flightManagementSystem.service.RouteService;

@ControllerAdvice
@RestController
public class RouteFlightController {

    @Autowired
    private RouteDao routeDao;
    @Autowired
    private RouteService routeService;
    @Autowired
    private AirportDao airportDao;
    @Autowired
    private FlightDao flightDao;
    @Autowired
    private FlightService flightService;

    // Displays the route entry page with a new route ID
    @GetMapping("/routeEntryPage")
    public ModelAndView showRouteEntryPage() {
        Long newRouteId = routeDao.generateRouteId();
        Route route = new Route();
        route.setRouteId(newRouteId);
        ModelAndView mv = new ModelAndView("routeEntryPage");
        mv.addObject("routeRecord", route);
        return mv;
    }

    // Saves a new route and its return route to the database
    @PostMapping("/route")
    public ModelAndView saveRoutes(@ModelAttribute("routeRecord") Route route1) {
        String source = route1.getSourceAirportCode().toUpperCase();
        String destination = route1.getDestinationAirportCode().toUpperCase();
        if (source.equalsIgnoreCase(destination))
            throw new RouteException("From-City & To-City cannot be the same......");

        String sourceCode = airportDao.findAirportCodeByLocation(route1.getSourceAirportCode());
        System.out.println("source code is " + sourceCode);
        String destinationCode = airportDao.findAirportCodeByLocation(route1.getDestinationAirportCode());
        System.out.println("destination code is " + destinationCode);
        route1.setSourceAirportCode(sourceCode);
        route1.setDestinationAirportCode(destinationCode);
        Route route2 = routeService.createReturnRoute(route1);
        routeDao.save(route1);
        routeDao.save(route2);
        return new ModelAndView("redirect:/index");
    }

    // Displays a report page with a list of all routes
    @GetMapping("/routes")
    public ModelAndView showRouteReportPage() {
        List<Route> routeList = routeDao.findAllRoutes();
        ModelAndView mv = new ModelAndView("routeReportPage");
        mv.addObject("routeList", routeList);
        return mv;
    }

    // Displays the flight entry page with a list of route IDs
    @GetMapping("/flight")
    public ModelAndView showFlightEntryPage() {
        List<Long> routeList = routeDao.findAllRoutesId();
        Flight flight = new Flight();
        ModelAndView mv = new ModelAndView("flightEntryPage");
        mv.addObject("flightRecord", flight);
        mv.addObject("routeList", routeList);
        return mv;
    }

    // Saves a new flight and its return flight to the database
    @PostMapping("/flight")
    public ModelAndView saveFlights(@ModelAttribute("flightRecord") Flight flight1, @RequestParam("dtime") String dtime,
            @RequestParam("atime") String atime) {
        Flight flight2 = flightService.createReturnFlight(flight1, dtime, atime);
        if (flight1.getRouteId().equals(flight2.getRouteId()))
            throw new FlightException("From-City & To-City cannot be the same......");
        flightDao.save(flight1);
        flightDao.save(flight2);
        return new ModelAndView("redirect:/index");
    }

    // Displays a report page with a list of all flights
    @GetMapping("/flights")
    public ModelAndView showFlightReportPage() {
        List<Flight> flightList = flightDao.findAllFlights();
        ModelAndView mv = new ModelAndView("flightReportPage");
        mv.addObject("flightList", flightList);
        return mv;
    }

    // Displays a page to select a route for flight search
    @GetMapping("/searchflight")
    public ModelAndView showRouteSelectPage() {
        List<String> airportList = airportDao.findAllAirportLocations();
        ModelAndView mv = new ModelAndView("routeSelectPage");
        mv.addObject("airportList", airportList);
        return mv;
    }

    // Displays a page with flights for the selected route
    @PostMapping("/searchflight")
    public ModelAndView showRouteFlightsPage(@RequestParam("from_city") String fromCity,
            @RequestParam("to_city") String toCity) {
        String fromAirport = airportDao.findAirportCodeByLocation(fromCity);
        String toAirport = airportDao.findAirportCodeByLocation(toCity);
        if (fromAirport.equalsIgnoreCase(toAirport))
            throw new FlightException("From-City & To-City cannot be the same......");
        Route route = routeDao.findRouteBySourceAndDestination(fromAirport, toAirport);
        if (route == null)
            throw new FlightException("No flights available for the selected route......");
        List<Flight> flightList = flightDao.findFlightsByRouteId(route.getRouteId());
        if (flightList.isEmpty())
            throw new FlightException("No flights available for the selected route......");
        ModelAndView mv = new ModelAndView("routeFlightShowPage");
        mv.addObject("flightList", flightList);
        mv.addObject("fromAirport", fromCity);
        mv.addObject("toAirport", toCity);
        mv.addObject("fare", route.getFare());
        return mv;
    }

    // Handles RouteException and redirects to the route error page with the error
    // message
    @ExceptionHandler(value = RouteException.class)
    public ModelAndView handlingRouteException(RouteException exception) {
        String message = "From-City & To-City cannot be the same......";
        ModelAndView mv = new ModelAndView("routeErrorPage");
        mv.addObject("routeError", message);
        return mv;
    }

    // Handles FlightException and redirects to the flight error page with the error
    // message
    @ExceptionHandler(value = FlightException.class)
    public ModelAndView handlingFlightException(FlightException exception) {
        String message = "From-City & To-City cannot be the same......";
        ModelAndView mv = new ModelAndView("flightErrorPage");
        mv.addObject("flightError", message);
        return mv;
    }
}