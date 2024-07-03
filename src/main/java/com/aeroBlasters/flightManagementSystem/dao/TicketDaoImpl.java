package com.aeroBlasters.flightManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aeroBlasters.flightManagementSystem.bean.Ticket;

@Repository
public class TicketDaoImpl implements TicketDao {
    @Autowired
    private TicketRepository repository;

    @Override
    public void save(Ticket ticket) {
        System.out.println("Ticket Number: from DAO IMPL" + ticket.getCarrierName());
        repository.save(ticket);
    }

    @Override
    public Long findLastTicketNumber() {
        Long val = repository.findLastTicketNumber();
        if (val == null)
            val = 1000001L;
        return val;
    }

    @Override
    public Ticket findTicketByTicketNumber(Long ticketNumber) {
        return repository.findById(ticketNumber).get();
    }
}