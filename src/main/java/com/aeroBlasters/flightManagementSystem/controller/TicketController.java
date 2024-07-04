package com.aeroBlasters.flightManagementSystem.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aeroBlasters.flightManagementSystem.bean.Flight;
import com.aeroBlasters.flightManagementSystem.bean.Passenger;
import com.aeroBlasters.flightManagementSystem.bean.Route;
import com.aeroBlasters.flightManagementSystem.bean.Ticket;
import com.aeroBlasters.flightManagementSystem.dao.PassengerDao;
import com.aeroBlasters.flightManagementSystem.dao.RouteDao;
import com.aeroBlasters.flightManagementSystem.dao.TicketDao;
import com.aeroBlasters.flightManagementSystem.dao.FlightDao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@ControllerAdvice
@RestController
public class TicketController {
    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private PassengerDao passengerDao;

    @Autowired
    private RouteDao RouteDao;

    @Autowired
    private FlightDao FlightDao;

    @GetMapping("/ticket/{id}")
    public ModelAndView showTicketForm(@PathVariable Long id) {
        Flight flight = FlightDao.findFlightById(id);
        Route route = RouteDao.findRouteById(flight.getRouteId());
        Long newTicketId = ticketDao.findLastTicketNumber() + 1;
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(newTicketId);
        ticket.setFlightNumber(flight.getFlightNumber());
        ticket.setCarrierName(flight.getCarrierName());
        // ticket.setFromCity(route.getFromCity());
        // ticket.setToCity(route.getToCity());
        // ticket.setTotalAmount(flight.getFare());
        ModelAndView mv = new ModelAndView("ticketBookingPage");
        mv.addObject("ticketRecord", ticket);
        mv.addObject("flight", flight);
        mv.addObject("route", route);
        return mv;
    }

    @PostMapping("/ticket")
    public ModelAndView processTicketBooking(@ModelAttribute("ticketRecord") Ticket ticket,
            HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("showTicketPage");
        String fromCity = request.getParameter("fromLocation");
        String toCity = request.getParameter("toLocation");
        String carrierName = request.getParameter("carrierName");
        String fare = request.getParameter("totalAmount");
        System.out.println("fromcity = " + fromCity);
        System.out.println("toCity = " + toCity);
        System.out.println("totalAmount = " + fare);
        System.out.println("flightNumber = " + request.getParameter("flightNumber"));
        System.out.println("carrierName = " + carrierName);
        System.out.println("Fare = " + fare);

        String pname = "";
        String dob = "";
        for (int i = 1; i <= 6; i++) {
            pname = request.getParameter("name" + i);
            dob = request.getParameter("dob" + i);
            if (pname != null && !pname.isEmpty()) {
                Passenger passenger = new Passenger();
                passenger.setPassengerName(pname);
                passenger.setDob(dob);
                passenger.setTicket(ticket); // Associate passenger with the ticket
                passengerDao.save(passenger); // Save passenger
            }
        }
        ticket.setTicketNumber(ticketDao.findLastTicketNumber() + 1);
        ticket.setFromCity(fromCity);
        ticket.setToCity(toCity);
        ticket.setCarrierName(carrierName);
        ticket.setFare(fare);

        System.out.println("Ticket Number: from DAO IMPL" + ticket.getTicketNumber());
        System.out.println("From City: " + ticket.getFromCity());
        System.out.println("To City: " + ticket.getToCity());
        System.out.println("Carrier Name: " + ticket.getCarrierName());
        System.out.println("Fare: " + ticket.getFare());

        ticketDao.save(ticket);

        return mv;
        // ModelAndView mv = new ModelAndView("showTicketPage");
        // Long ticketNumber = ticketDao.findLastTicketNumber() + 1;
        // ticket.setTicketNumber(ticketNumber);

        // System.out.println("fromcity = " +
        // request.getParameter("fromLocation"));
        // System.out.println("toCity = " + request.getParameter("toLocation"));
        // System.out.println("totalAmount = " +
        // request.getParameter("totalAmount"));
        // System.out.println("flightNumber = " +
        // request.getParameter("flightNumber"));
        // // System.out.println("arrivalDate = " +
        // request.getParameter("arrivalDate"));
        // System.out.println("carrierName = " + request.getParameter("carrierName"));

        // // Assuming these fields are directly related to the Ticket model
        // ticket.setFromCity(request.getParameter("fromLocation"));
        // ticket.setToCity(request.getParameter("toLocation"));
        // ticket.setTotalAmount(Double.parseDouble(request.getParameter("totalAmount")));
        // ticket.setFlightNumber(Long.parseLong(request.getParameter("flightNumber")));
        // // ticket.setFare(request.getParameter("fare"));
        // // ticket.setDepartureDate(request.getParameter("departureDate"));
        // // ticket.setArrivalDate(request.getParameter("arrivalDate"));
        // ticket.setCarrierName(request.getParameter("carrierName"));

        // ticketDao.save(ticket); // Save the ticket first to generate an ID

        // // Process passenger information
        // for (int i = 1; i <= 6; i++) {
        // String pname = request.getParameter("name" + i);
        // String dob = request.getParameter("dob" + i);
        // if (pname != null && !pname.isEmpty()) {
        // Passenger passenger = new Passenger();
        // passenger.setPassengerName(pname);
        // passenger.setDob(dob);
        // passenger.setTicket(ticket); // Associate passenger with the ticket
        // passengerDao.save(passenger); // Save passenger
        // }
        // }

        // mv.addObject("ticket", ticket);
        // return mv;
    }

    // @PostMapping("/ticket")
    // public ModelAndView processTicketBooking(@ModelAttribute("ticketRecord")
    // Ticket ticket) {
    // Long ticketNumber = ticketDao.findLastTicketNumber() + 1;
    // ticket.setTicketNumber(ticketNumber);
    // System.out.println("Ticket Number: " + ticket.getTicketNumber());
    // ticketDao.save(ticket);
    // ModelAndView mv = new ModelAndView("showTicketPage");
    // mv.addObject("ticket", ticket);
    // return mv;
    // }

    @GetMapping("/showTicket/{ticketNumber}")
    public ModelAndView showTicketPage(@PathVariable("ticketNumber") Long ticketNumber) {
        Ticket ticket = ticketDao.findTicketByTicketNumber(ticketNumber);
        ModelAndView mv = new ModelAndView("showTicketPage");
        mv.addObject("ticket", ticket);
        return mv;
    }
}
