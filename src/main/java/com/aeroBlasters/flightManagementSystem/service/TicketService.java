package com.aeroBlasters.flightManagementSystem.service;

public class TicketService {
    // Existing methods remain unchanged

    // New method to calculate final ticket price
    public Double calculateFinalTicketPrice(Integer birthYear, Double basePrice, Integer totalSeats, Integer bookedSeats) {
        // Calculate age
        Integer age = ageCalculation(birthYear);
        
        // Check if tickets are available
        Integer availableSeats = capacityCalculation(totalSeats, bookedSeats);
        if (availableSeats <= 0) {
            throw new IllegalStateException("No tickets available");
        }
        
        // Apply discount based on age
        Double discountedPrice = discount(basePrice, age);
        
        return discountedPrice;
    }
    
    // discount() - No changes
    public Double discount(Double totalAmount, int age) {
        final double CHILD_DISCOUNT = 0.3; // 30% discount
        final double YOUTH_DISCOUNT = 0.2; // 20% discount
        final double ELDERLY_DISCOUNT = 0.25; // 25% discount
        final double NO_DISCOUNT = 0.1; // 10% discount for others

        if (age < 12) {
            return totalAmount - (totalAmount * CHILD_DISCOUNT);
        } else if (age >= 12 && age <= 24) {
            return totalAmount - (totalAmount * YOUTH_DISCOUNT);
        } else if (age >= 65) {
            return totalAmount - (totalAmount * ELDERLY_DISCOUNT);
        } else {
            return totalAmount - (totalAmount * NO_DISCOUNT);
        }
    }

    // ageCalculation() - No changes
    public Integer ageCalculation(Integer year) {
        return 2024 - year; // Consider updating the current year dynamically
    }

    // capacityCalculation() - No changes
    public Integer capacityCalculation(Integer totalSeats, Integer bookedSeats) {
        return totalSeats - bookedSeats;
    }
}