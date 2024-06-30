// package com.aeroBlasters.flightManagementSystem.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.convert.Delimiter;
// import java.util.Random;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.ModelAndView;

// import com.aeroBlasters.flightManagementSystem.service.FlightService;
// import com.aeroBlasters.flightManagementSystem.bean.Airport;
// import com.aeroBlasters.flightManagementSystem.bean.Flight;
// import com.aeroBlasters.flightManagementSystem.dao.AirportDao;
// import com.aeroBlasters.flightManagementSystem.dao.FlightDao;;

// @RestController
// // @RequestMapping("/flights")
// public class FlightController {

// @Autowired
// private FlightDao flightDao;
// @Autowired
// private FlightService flightService;
// @Autowired
// private AirportDao airportDao;

// @GetMapping("/flightEntryPage")
// public ModelAndView showFlightEntryPage() {
// Long newFlightId = (long) (Math.random() * 90000) + 10000;
// Flight flight = new Flight();
// flight.setFlight_number(newFlightId);
// ModelAndView mv = new ModelAndView("flightEntryPage");
// mv.addObject("flightRecord", flight);
// return mv;
// }

// @PostMapping("/flights")
// public ModelAndView saveFlights(@ModelAttribute("flightRecord") Flight
// flight1) {
// Random random = new Random();
// int flightNumber = random.nextInt(90000) + 10000;
// System.out.println(flightNumber);

// int seatCapacity = 250;
// int routeId = 101;

// String carrier = flight1.getCarrier_name().toUpperCase();
// flight1.setCarrier_name(carrier);
// String source = flight1.getArrival().toUpperCase();
// String destination = flight1.getDeparture().toUpperCase();
// System.out.println("Source: " + source + " Destination: " + destination);
// flight1.setArrival(source);
// flight1.setDeparture(destination);
// String sourceCode =
// airportDao.findAirportCodeByLocation(flight1.getArrival());
// String destinationCode =
// airportDao.findAirportCodeByLocation(flight1.getDeparture());
// flight1.setArrival(sourceCode);
// flight1.setDeparture(destinationCode);
// Flight flight2 = flightService.createReturnFlight(flight1, sourceCode,
// destinationCode);
// System.out.println("Flight 1: " + flight1 + " Flight 2: " + flight2);
// flightDao.save(flight1);
// flightDao.save(flight2);
// return new ModelAndView("index_2");
// }

// @GetMapping("/flights")
// public ModelAndView showFlightReportPage() {
// List<Flight> flights = flightDao.findAllFlights();
// ModelAndView mv = new ModelAndView("flightReportPage");
// mv.addObject("flights", flights);
// return mv;
// }

// // public FlightController(FlightService flightService) {
// // this.flightService = flightService;
// // }

// // @GetMapping("/")
// // public ResponseEntity<List<Flight>> getAllFlights() {
// // List<Flight> flights = flightService.findAllFlights();
// // return ResponseEntity.ok(flights);
// // }

// // @GetMapping("/{id}")
// // public ResponseEntity<Flight> getFlightById(Long id) {
// // Flight flight = flightService.findFlightById(id);
// // return ResponseEntity.ok(flight);
// // }

// // @PostMapping("/{id}")
// // public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
// // Flight newFlight = flightService.saveFlight(flight);
// // return ResponseEntity.ok(newFlight);
// // }

// // @PutMapping("/{id}")
// // public ResponseEntity<Flight> updateFlight(Long id, @RequestBody Flight
// // flightDetails) {
// // Flight updatedFlight = flightService.updateFlight(id, flightDetails);
// // return ResponseEntity.ok(updatedFlight);
// // }

// // @DeleteMapping("/{id}")
// // public ResponseEntity<Void> deleteFlight(Long id) {
// // flightService.deleteFlight(id);
// // return ResponseEntity.noContent().build();
// // }
// }
