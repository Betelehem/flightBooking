package mum.edu.flightbooking.repository;

import mum.edu.flightbooking.entity.AirPortLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPortRepository extends JpaRepository<AirPortLocation,Long> {
    AirPortLocation findByNickName(String nickName);
    //AirPortLocation deleteAirPortLocationByNickName(String nickName);
}
