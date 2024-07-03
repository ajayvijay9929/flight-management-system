package com.aeroBlasters.flightManagementSystem.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aeroBlasters.flightManagementSystem.bean.Ticket;
import com.aeroBlasters.flightManagementSystem.dao.TicketDao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@ControllerAdvice
@RestController
public class TicketController {
    @Autowired
    private TicketDao ticketDao;

    @GetMapping("/ticket")
    public ModelAndView showTicketBookingPage() {
        Long newTicketId = ticketDao.findLastTicketNumber();
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(newTicketId + 1);
        ModelAndView mv = new ModelAndView("ticketBookingPage");
        mv.addObject("ticketRecord", ticket);
        return mv;
    }

    @PostMapping("/ticket")
    public ModelAndView processTicketBooking(@ModelAttribute("ticketRecord") Ticket ticket) {
        Long ticketNumber = ticketDao.findLastTicketNumber() + 1;
        ticket.setTicketNumber(ticketNumber);
        System.out.println("Ticket Number: " + ticket.getTicketNumber());
        ticketDao.save(ticket);
        ModelAndView mv = new ModelAndView("showTicketPage");
        mv.addObject("ticket", ticket);
        return mv;
    }

    @GetMapping("/showTicket/{ticketNumber}")
    public ModelAndView showTicketPage(@PathVariable("ticketNumber") Long ticketNumber) {
        Ticket ticket = ticketDao.findTicketByTicketNumber(ticketNumber);
        ModelAndView mv = new ModelAndView("showTicketPage");
        mv.addObject("ticket", ticket);
        return mv;
    }
}
