package mum.edu.flightbooking.service;

import mum.edu.flightbooking.entity.AirPlane;

public interface AirPlaneService {
    AirPlane addAirPlane(AirPlane airPortLocation);
    AirPlane deleteAirPlane(String model);
}
