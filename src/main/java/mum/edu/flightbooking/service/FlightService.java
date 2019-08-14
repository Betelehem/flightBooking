package mum.edu.flightbooking.service;

import mum.edu.flightbooking.entity.Flight;

import java.util.List;

public interface FlightService {
    Flight addFlight(Flight flight);
    Flight findById(Long id);
    void deleteById(Long id);
    Flight cancelFlight(String flightNumber);
    List<Flight> allFlight();
}
