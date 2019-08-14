package mum.edu.flightbooking.repository;

import mum.edu.flightbooking.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    Flight findByFlightNumber(String flightNum);
    List<Flight> findAllByStartingTime(Date date);
}
