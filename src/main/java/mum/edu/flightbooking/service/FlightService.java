package mum.edu.flightbooking.service;

import mum.edu.flightbooking.entity.Flight;

public interface FlightService {
    Flight addFlight(Flight flight);
    Flight editFlight(Flight flight);
    Flight cancelFlight(String flightNumber);
}
