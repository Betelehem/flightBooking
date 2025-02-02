package mum.edu.flightbooking.controller;

import mum.edu.flightbooking.dto.AirPort;
import mum.edu.flightbooking.entity.AirPlane;
import mum.edu.flightbooking.entity.AirPortLocation;
import mum.edu.flightbooking.entity.Flight;
import mum.edu.flightbooking.service.AirPlaneService;
import mum.edu.flightbooking.service.AirPortLocationService;
import mum.edu.flightbooking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AirPortLocationService airPortLocationService;
    @Autowired
    private AirPlaneService airPlaneService;
    @Autowired
    private FlightService flightService;

    @GetMapping("/homePage")
    public String adminPage() {
        return "user/dashboard_layout";
    }

    ///////////////////////////////////////////////////////////////////////AirPort below
    @GetMapping("/airpage")
    public String airPortLocation(Model theModel) {

        AirPortLocation theAirPort = new AirPortLocation();
        theModel.addAttribute("airport", theAirPort);

        return "admin/addAirPort";
    }

    @PostMapping("/airpage")
    public String postAirPortLocation(@ModelAttribute("airport") AirPortLocation airPortLocation) {
        airPortLocationService.save(airPortLocation);
        return "redirect:/admin/homePage";
    }

    @GetMapping("/airportdelete")
    public String deleteAirPortGet(Model theModel) {
        AirPort theAirPort = new AirPort();
        theModel.addAttribute("deleteairport", theAirPort);
        return "admin/deleteAirPort";
    }

    @PostMapping("/airportdelete")
    public String deleteAirPortPost(@ModelAttribute("deleteairport") AirPort theAirPort) {
        airPortLocationService.delete(theAirPort.getNickName());
        return "redirect:/admin/homePage";
    }

    /////////////////////////////////////////////////////////////////////////////////////AirPlane below
    @GetMapping("/airplanepage")
    public String airPlaneAdd(Model theModel) {

        AirPlane theAirPlane = new AirPlane();
        theModel.addAttribute("airplane", theAirPlane);

        return "admin/addAirPlane";
    }

    @PostMapping("/airplanepage")
    public String postAirPlane(@ModelAttribute("airplane") AirPlane airPlane) {
        airPlaneService.addAirPlane(airPlane);
        return "redirect:/admin/homePage";
    }

    @GetMapping("/airplanedelete")
    public String deleteAirPlaneGet(Model theModel) {
        AirPort theAirPort = new AirPort();
        theModel.addAttribute("deleteairplane", theAirPort);
        return "admin/deleteAirPlane";
    }

    @PostMapping("/airplanedelete")
    public String deleteAirPlanePost(@ModelAttribute("deleteairplane") AirPort theAirPort) {

        airPlaneService.deleteAirPlane(theAirPort.getNickName());
        return "redirect:/admin/homePage";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////flight below
    @GetMapping("/addflight")
    public String addFlight(Model theModel) {
        Flight flight = new Flight();
        theModel.addAttribute("setflight", flight);
        return "admin/addFlight";
    }

    @PostMapping("/addflight")
    public String addFlightPost(@ModelAttribute("setflight") Flight flight) {

        flightService.addFlight(flight);

        return "redirect:/admin/homePage";
    }

    @GetMapping("/allflightadmin")
    public String editFlightGet(Model theModel) {
        theModel.addAttribute("editdelete", flightService.allFlight());
        return "admin/editDeletePage";
    }

    @GetMapping("/flightNumber")
    public String editPage(@RequestParam("flightId") Long flightId, Model theModel) {

        theModel.addAttribute("editflight", flightService.findById(flightId));

        return "admin/editPage";
    }
    @PostMapping("/flightNumber")
    public String editFlightPost(@ModelAttribute("editflight") Flight flight){
        System.out.println("id======================="+flight.getId());
        flightService.addFlight(flight);
//        flightService.deleteById(flight.getId());
        return "redirect:/admin/homePage";
    }
    @GetMapping("/cancelFlight")
    public String cancelFlight(@RequestParam("flightId") Long flightId){

        flightService.deleteById(flightId);

        return "admin/adminPage";
    }

}