package com.aeroBlasters.flightManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aeroBlasters.flightManagementSystem.bean.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}