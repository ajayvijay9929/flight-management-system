// package com.aeroBlasters.flightManagementSystem.controller;

// import java.util.Date;
// import java.util.List;

// import javax.servlet.http.HttpServletRequest;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.ModelAndView;

// import com.aeroBlasters.flightManagementSystem.bean.Airport;
// import com.aeroBlasters.flightManagementSystem.bean.Flight;
// import com.aeroBlasters.flightManagementSystem.bean.Passenger;
// import com.aeroBlasters.flightManagementSystem.bean.Route;
// import com.aeroBlasters.flightManagementSystem.bean.Ticket;
// import com.aeroBlasters.flightManagementSystem.dao.PassengerDao;
// import com.aeroBlasters.flightManagementSystem.dao.RouteDao;
// import com.aeroBlasters.flightManagementSystem.dao.TicketDao;
// import com.aeroBlasters.flightManagementSystem.service.TicketService;
// import com.aeroBlasters.flightManagementSystem.dao.AirportDao;
// import com.aeroBlasters.flightManagementSystem.dao.FlightDao;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;

// @ControllerAdvice
// @RestController
// public class TicketController {
//     @Autowired
//     private TicketDao ticketDao;

//     @Autowired
//     private PassengerDao passengerDao;

//     @Autowired
//     private RouteDao RouteDao;

//     @Autowired
//     private FlightDao FlightDao;

//     @Autowired
//     private AirportDao AirportDao;

//     private TicketService ticketService;

//     @GetMapping("/ticket/{id}")
//     public ModelAndView showTicketForm(@PathVariable Long id) {
//         Flight flight = FlightDao.findFlightById(id);
//         Route route = RouteDao.findRouteById(flight.getRouteId());
//         Airport sourceAirport = AirportDao.findAirportById(route.getSourceAirportCode());
//         Airport destinationAirport = AirportDao.findAirportById(route.getDestinationAirportCode());
//         Long newTicketId = ticketDao.findLastTicketNumber() + 1;
//         Ticket ticket = new Ticket();
//         ticket.setTicketNumber(newTicketId);
//         ticket.setFlightNumber(flight.getFlightNumber());
//         ticket.setCarrierName(flight.getCarrierName());
//         ticket.setFare("5000");
//         // ticket.setFromCity(route.getFromCity());
//         // ticket.setToCity(route.getToCity());
//         // ticket.setTotalAmount(flight.getFare());
//         ModelAndView mv = new ModelAndView("ticketBookingPage");
//         mv.addObject("ticketRecord", ticket);
//         mv.addObject("flight", flight);
//         mv.addObject("route", route);
//         mv.addObject("sourceAirport", sourceAirport);
//         mv.addObject("destinationAirport", destinationAirport);
//         return mv;
//     }

//     // @PostMapping("/ticket")
//     // public ModelAndView processTicketBooking(@ModelAttribute("ticketRecord")
//     // Ticket ticket,
//     // HttpServletRequest request) {
//     // ModelAndView mv = new ModelAndView("showTicketPage");
//     // String fromCity = request.getParameter("fromLocationHidden");
//     // String toCity = request.getParameter("toLocationHidden");
//     // String carrierName = request.getParameter("carrierNameHidden");
//     // String fare = request.getParameter("totalAmount");

//     // System.out.println("fromcity = " + fromCity);
//     // System.out.println("toCity = " + toCity);
//     // System.out.println("totalAmount = " + fare);
//     // System.out.println("flightNumber = " + request.getParameter("flightNumber"));
//     // System.out.println("carrierName = " + carrierName);
//     // System.out.println("Fare = " + fare);

//     // String pname = "";
//     // String dob = "";
//     // for (int i = 1; i <= 6; i++) {
//     // pname = request.getParameter("name" + i);
//     // dob = request.getParameter("dob" + i);
//     // if (pname != null && !pname.isEmpty()) {
//     // Passenger passenger = new Passenger();
//     // passenger.setPassengerName(pname);
//     // passenger.setDob(dob);
//     // passenger.setTicket(ticket); // Associate passenger with the ticket
//     // passengerDao.save(passenger); // Save passenger
//     // }
//     // }
//     // ticket.setTicketNumber(ticketDao.findLastTicketNumber() + 1);
//     // ticket.setFromCity(fromCity);
//     // ticket.setToCity(toCity);
//     // ticket.setCarrierName(carrierName);
//     // ticket.setFare(fare);

//     // System.out.println("Ticket Number: from DAO IMPL" +
//     // ticket.getTicketNumber());
//     // System.out.println("From City: " + ticket.getFromCity());
//     // System.out.println("To City: " + ticket.getToCity());
//     // System.out.println("Carrier Name: " + ticket.getCarrierName());
//     // System.out.println("Fare: " + ticket.getFare());

//     // ticketDao.save(ticket);

//     // return mv;
//     // }

//     // @PostMapping("/ticket")
//     // public ModelAndView processTicketBooking(@ModelAttribute("ticketRecord")
//     // Ticket ticket,
//     // HttpServletRequest request) {
//     // Long ticketNumber = ticketDao.findLastTicketNumber() + 1;
//     // ticket.setTicketNumber(ticketNumber);
//     // System.out.println("Ticket Number: " + ticket.getTicketNumber());
//     // // ticketDao.save(ticket);
//     // ModelAndView mv = new ModelAndView("showTicketPage");

//     // System.out.println("Ticket Number: from DAO IMPL" +
//     // ticket.getTicketNumber());
//     // // Extract additional parameters not bound to the Ticket model
//     // String fromCity = request.getParameter("fromLocation");
//     // String toCity = request.getParameter("toLocation");
//     // String carrierName = request.getParameter("carrierName");
//     // String fare = request.getParameter("totalAmount");

//     // // sysout
//     // System.out.println("fromcity = " + fromCity);
//     // System.out.println("toCity = " + toCity);
//     // System.out.println("totalAmount = " + fare);
//     // System.out.println("flightNumber = " + request.getParameter("flightNumber"));
//     // System.out.println("carrierName = " + carrierName);
//     // System.out.println("Fare = " + fare);

//     // // Set these additional parameters to the Ticket object
//     // ticket.setFromCity(fromCity);
//     // ticket.setToCity(toCity);
//     // ticket.setCarrierName(carrierName);
//     // ticket.setFare(fare);

//     // // Assuming the number of passengers is sent as a parameter
//     // int numberOfPassengers =
//     // Integer.parseInt(request.getParameter("numberOfPassengers"));

//     // for (int i = 1; i <= numberOfPassengers; i++) {
//     // String pname = request.getParameter("pname" + i);
//     // String dob = request.getParameter("dob" + i);
//     // if (pname != null && !pname.isEmpty()) {
//     // Passenger newPassenger = new Passenger(); // Renamed to avoid conflict
//     // newPassenger.setPassengerName(pname);
//     // newPassenger.setDob(dob);
//     // newPassenger.setTicket(ticket); // Associate passenger with the ticket
//     // // Assuming passengerDao is an instance of a DAO class for saving passengers
//     // passengerDao.save(newPassenger); // Save passenger
//     // }
//     // }

//     // // Save the ticket
//     // // Assuming ticketDao is an instance of a DAO class for saving tickets
//     // ticketDao.save(ticket);

//     // // Add objects to the ModelAndView if needed, for displaying in the view
//     // mv.addObject("ticket", ticket);
//     // // Add any other necessary objects to the ModelAndView

//     // return mv;
//     // }

//     @PostMapping("/ticket")
//     public ModelAndView openShowTicketPage(@ModelAttribute("ticketRecord") Ticket ticket, HttpServletRequest request) {
//         Long ticketNumber = ticketDao.findLastTicketNumber() + 1;
//         ticket.setTicketNumber(ticketNumber);
//         System.out.println("Ticket Number: " + ticket.getTicketNumber());
//         ticketDao.save(ticket);
//         ModelAndView mv = new ModelAndView("showTicketPage");
//         String fromCity = request.getParameter("fromLocation");
//         String toCity = request.getParameter("toLocation");
//         String Fare = request.getParameter("Fare");
//         System.out.print(fromCity + "  " + toCity + "  " + Fare + "  ");
//         String pname = "";
//         String dob = "";
//         for (int i = 1; i <= 6; i++) {
//             pname = request.getParameter("name" + i);
//             dob = request.getParameter("dob" + i);

//         }
//         // mv.addObject("ticket", ticket);
//         return mv;

//     }

//     @GetMapping("/showTicket/{ticketNumber}")
//     public ModelAndView showTicketPage(@PathVariable("ticketNumber") Long ticketNumber) {
//         Ticket ticket = ticketDao.findTicketByTicketNumber(ticketNumber);
//         ModelAndView mv = new ModelAndView("showTicketPage");
//         mv.addObject("ticket", ticket);
//         return mv;
//     }
// }

package com.aeroBlasters.flightManagementSystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aeroBlasters.flightManagementSystem.bean.Flight;
import com.aeroBlasters.flightManagementSystem.bean.Route;
import com.aeroBlasters.flightManagementSystem.bean.Ticket;
import com.aeroBlasters.flightManagementSystem.dao.FlightDao;
import com.aeroBlasters.flightManagementSystem.dao.RouteDao;
import com.aeroBlasters.flightManagementSystem.dao.TicketDao;

@ControllerAdvice
@RestController
public class TicketController {

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private FlightDao flightDao;

    @Autowired
    private RouteDao routeDao;

    @GetMapping("/ticket/{id}")
    public ModelAndView showTicketForm(@PathVariable Long id) {
        Flight flight = flightDao.findFlightById(id);
        Route route = routeDao.findRouteById(flight.getRouteId());
        Long newTicketId = ticketDao.findLastTicketNumber() + 1;
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(newTicketId);
        ticket.setFlightNumber(flight.getFlightNumber());
        ticket.setCarrierName(flight.getCarrierName());
        ModelAndView mv = new ModelAndView("ticketBookingPage");
        mv.addObject("ticketRecord", ticket);
        mv.addObject("flight", flight);
        mv.addObject("route", route);
        return mv;
    }

    @PostMapping("/ticket")
    public ModelAndView openShowTicketPage(@ModelAttribute("ticketRecord") Ticket ticket, HttpServletRequest request) {
        Long ticketNumber = ticketDao.findLastTicketNumber() + 1;
        ticket.setTicketNumber(ticketNumber);
        System.out.println("Ticket Number: " + ticket.getTicketNumber());
        ticketDao.save(ticket);
        ModelAndView mv = new ModelAndView("showTicketPage");
        String fromCity = request.getParameter("fromLocation");
        String toCity = request.getParameter("toLocation");
        String fare = request.getParameter("fare");
        System.out.print(fromCity + "  " + toCity + "  " + fare + "  ");
        String pname = "";
        String dob = "";
        for (int i = 1; i <= 6; i++) {
            pname = request.getParameter("name" + i);
            dob = request.getParameter("dob" + i);

        }
        mv.addObject("ticketRecord", ticket);
        return mv;

    }

    @GetMapping("/showTicket/{ticketNumber}")
    public ModelAndView showTicketPage(@PathVariable("ticketNumber") Long ticketNumber) {
        Ticket ticket = ticketDao.findTicketByTicketNumber(ticketNumber);

        ModelAndView mv = new ModelAndView("showTicketPage");
        mv.addObject("ticketRecord", ticket);

        return mv;
    }

}
