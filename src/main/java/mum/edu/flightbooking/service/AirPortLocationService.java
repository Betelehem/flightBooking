package mum.edu.flightbooking.service;

import mum.edu.flightbooking.entity.AirPortLocation;

public interface AirPortLocationService {
    AirPortLocation save(AirPortLocation airPortLocation);
    AirPortLocation delete(String nickName);
}
