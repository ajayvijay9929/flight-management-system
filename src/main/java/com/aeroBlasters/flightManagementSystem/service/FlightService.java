package com.aeroBlasters.flightManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aeroBlasters.flightManagementSystem.bean.Flight;
import com.aeroBlasters.flightManagementSystem.bean.Route;
import com.aeroBlasters.flightManagementSystem.dao.FlightDao;
import com.aeroBlasters.flightManagementSystem.dao.RouteDao;

/**
 * Service class for managing flight-related operations.
 * This class provides business logic for creating return flights, among other
 * functionalities.
 */
@Service
public class FlightService {

    @Autowired
    private RouteDao routeDao; // Injects the RouteDao to access route-related data operations.

    /**
     * Creates a return flight based on the provided flight details.
     * The return flight is created by swapping the source and destination of the
     * original flight,
     * and adjusting the departure and arrival times.
     * 
     * @param flight The original flight for which the return flight is to be
     *               created.
     * @param dtime  The departure time for the return flight.
     * @param atime  The arrival time for the return flight.
     * @return A new Flight object representing the return flight.
     */
    public Flight createReturnFlight(Flight flight, String dtime, String atime) {
        Long newId = flight.getFlightNumber() + 1; // Generates a new flight number by incrementing the original
                                                   // flight's number.
        Route route = routeDao.findRouteById(flight.getRouteId()); // Retrieves the route of the original flight.
        String sourceCode = route.getDestinationAirportCode(); // Swaps the source and destination for the return
                                                               // flight.
        String destinationCode = route.getSourceAirportCode();
        Double fare = route.getFare(); // Retrieves the fare for the route, assuming it's needed for further
                                       // operations.
        Long newRouteId = routeDao.findRouteBySourceAndDestination(sourceCode, destinationCode, fare); // Finds or
                                                                                                       // creates a new
                                                                                                       // route ID based
                                                                                                       // on the swapped
                                                                                                       // source and
                                                                                                       // destination.
        return new Flight(newId, flight.getCarrierName(), newRouteId, flight.getSeatCapacity(), dtime, atime); // Creates
                                                                                                               // and
                                                                                                               // returns
                                                                                                               // the
                                                                                                               // new
                                                                                                               // Flight
                                                                                                               // object.
    }

}