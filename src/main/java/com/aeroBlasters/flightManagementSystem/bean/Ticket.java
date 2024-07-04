package com.aeroBlasters.flightManagementSystem.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket {
    @Id
    private Long ticketNumber;

    @NotNull
    private Long routeId;

    @NotNull
    private Long flightNumber;

    @NotNull
    @Size(min = 1, max = 100)
    private String carrierName;
    private String fromCity;
    private String toCity;
    private String fare;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Passenger> passengers = new ArrayList<>();

    public Ticket() {
        super();
    }

    // Getters and setters for existing fields

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        passenger.setTicket(this);
    }

    public Ticket(Long ticketNumber, Long routeId, Long flightNumber, String carrierName, String fare) {
        this.ticketNumber = ticketNumber;
        this.routeId = routeId;
        this.flightNumber = flightNumber;
        this.carrierName = carrierName;
        this.fare = fare;
    }

    public void setTicketNumber(Long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Long getTicketNumber() {
        return ticketNumber;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    // Assuming getters for the new fields are also needed
    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public String getFare() {
        return fare;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setFlightNumber(Long flightNumber) {
        this.flightNumber = flightNumber;
    }

}