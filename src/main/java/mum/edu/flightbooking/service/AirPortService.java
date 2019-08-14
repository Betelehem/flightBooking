package mum.edu.flightbooking.service;

import mum.edu.flightbooking.entity.AirPortLocation;

public interface AirPortService {
    AirPortLocation addAirPortLocation(AirPortLocation airPortLocation);
    AirPortLocation deleteAirPortLocation(String nickName);
}
