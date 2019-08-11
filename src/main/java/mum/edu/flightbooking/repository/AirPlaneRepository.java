package mum.edu.flightbooking.repository;

import mum.edu.flightbooking.entity.AirPlane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPlaneRepository extends JpaRepository<AirPlane,Long> {
    AirPlane findBySerialNumber(String serialNum);
}
