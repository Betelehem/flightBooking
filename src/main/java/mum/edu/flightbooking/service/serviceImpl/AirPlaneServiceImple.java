package mum.edu.flightbooking.service.serviceImpl;

import mum.edu.flightbooking.entity.AirPlane;
import mum.edu.flightbooking.repository.AirPlaneRepository;
import mum.edu.flightbooking.service.AirPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirPlaneServiceImple implements AirPlaneService {

    @Autowired
    private AirPlaneRepository airPlaneRepository;

    @Override
    public AirPlane addAirPlane(AirPlane airPlane) {

        if(airPlaneRepository.findBySerialNumber(airPlane.getSerialNumber())!=null){
            System.out.println("airPlane already is exist");
            return null;
        }

        return airPlaneRepository.save(airPlane);
    }

    @Override
    public AirPlane deleteAirPlane(String serial) {
        if(airPlaneRepository.findBySerialNumber(serial)==null){
            System.out.println("airPlane already is exist");
            return null;
        }

        AirPlane temp=airPlaneRepository.findBySerialNumber(serial);
        Long tempId=temp.getId();
        airPlaneRepository.deleteById(tempId);

        return temp;
    }
}
