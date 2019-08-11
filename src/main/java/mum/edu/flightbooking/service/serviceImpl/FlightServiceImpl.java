package mum.edu.flightbooking.service.serviceImpl;

import mum.edu.flightbooking.entity.Flight;
import mum.edu.flightbooking.repository.AirPlaneRepository;
import mum.edu.flightbooking.repository.AirPortLocationRepository;
import mum.edu.flightbooking.repository.FlightRepository;
import mum.edu.flightbooking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AirPlaneRepository airPlaneRepository;
    @Autowired
    private AirPortLocationRepository airPortLocationRepository;


    @Override
    public Flight addFlight(Flight flight) {

        String airPlaneSerial=flight.getAirPlane().getSerialNumber();
       // String departNickName=flight.getDeprtureAirPort().getNickName();
       // String arrivalNickName=flight.getArrivalAirPort().getNickName();

        if(airPlaneRepository.findBySerialNumber(airPlaneSerial)==null){
            System.out.println("the air plane is not available at this time");
            return null;
        }
      //  if(airPortLocationRepository.findByNickName(departNickName)==null
       //         || airPortLocationRepository.findByNickName(arrivalNickName)==null
         //       || departNickName.equals(arrivalNickName)){

            System.out.println("one of the air port does not exist please check again");
            return null;
        }
      //  flight.setAirPlane(airPlaneRepository.findBySerialNumber(airPlaneSerial));
       // flight.setDeprtureAirPort(airPortLocationRepository.findByNickName(departNickName));
      //  flight.setArrivalAirPort(airPortLocationRepository.findByNickName(arrivalNickName));

       // return flightRepository.save(flight);
   // }

    @Override
    public Flight editFlight(Flight flight) {
        if(flightRepository.findByFlightNumber(flight.getFlightNumber())!=null){
            System.out.println("this flight is not exist");
            return null;
        }
        Long tempId=flightRepository.findByFlightNumber(flight.getFlightNumber()).getId();
        flightRepository.deleteById(tempId);
        flight.setId(tempId);

        return flightRepository.save(flight);
    }

    @Override
    public Flight cancelFlight(String flightNumber) {

        if(flightRepository.findByFlightNumber(flightNumber)!=null){
            System.out.println("the flight does not exist");
            return null;
        }
        Long tempId=flightRepository.findByFlightNumber(flightNumber).getId();
        flightRepository.deleteById(tempId);
        return flightRepository.findByFlightNumber(flightNumber);
    }
}
