package mum.edu.flightbooking.repository;

import mum.edu.flightbooking.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    Flight findByFlightNumber(String flightNum);
}
