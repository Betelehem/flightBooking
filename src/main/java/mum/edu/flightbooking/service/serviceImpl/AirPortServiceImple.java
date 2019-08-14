package mum.edu.flightbooking.service.serviceImpl;

import mum.edu.flightbooking.entity.AirPortLocation;
import mum.edu.flightbooking.repository.AirPortRepository;
import mum.edu.flightbooking.service.AirPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirPortServiceImple implements AirPortService {

    @Autowired
    private AirPortRepository airPortLocationRepository;

    @Override
    public AirPortLocation addAirPortLocation(AirPortLocation airPortLocation) {

        if(airPortLocationRepository.findByNickName(airPortLocation.getNickName())!=null){
            System.out.println("the location already is exist");
            return null;
        }

        return airPortLocationRepository.save(airPortLocation);
    }

    @Override
    public AirPortLocation deleteAirPortLocation(String nickName) {
        if(airPortLocationRepository.findByNickName(nickName)==null){
            System.out.println("the location does not exist");
            return null;
        }

        AirPortLocation temp=airPortLocationRepository.findByNickName(nickName);
        Long tempId=temp.getId();
        airPortLocationRepository.deleteById(tempId);


        return temp;
    }
}
