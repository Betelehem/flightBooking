package mum.edu.flightbooking.controller;

import mum.edu.flightbooking.dto.BookDTO;
import mum.edu.flightbooking.entity.Flight;
import mum.edu.flightbooking.entity.User;
import mum.edu.flightbooking.service.BookingService;
import mum.edu.flightbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;

    @GetMapping("/sign")
    public String getSignUp(Model theModel){
        User theUser = new User();
        theModel.addAttribute("user", theUser);

        return "user/signup";
    }

    @PostMapping("/sign")
    public String postSignUp(@ModelAttribute("user") User theUser){


        userService.save(theUser);

        return "redirect:/home";
    }

    /////////////////////////////////////////////////////////////booking below
    @GetMapping("/findingform")
    public String getFindForm(Model theModel){
        BookDTO bookDTO=new BookDTO();
        theModel.addAttribute("search",bookDTO);
        return "user/findingPage";
    }
    @PostMapping("/findingform")
    public String postFindForm(@ModelAttribute("search")BookDTO bookDTO, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("flightList",bookingService.availableFlights(bookDTO));
        return "redirect:/user/availableFlights";
    }
    @GetMapping("/availableFlights")
    public String allAvailableFlight(@ModelAttribute("flightList") List<Flight> flightList, Model theModel){
        theModel.addAttribute("allavailable",flightList);
        return "user/availableFlightPage";
    }
    /////////////////////////////////////////////////////////////login
//
//    @GetMapping("/flightNumber")
//    public String getLogInPage(@RequestParam("flightId") Long flightId,Model theModel){
//
//
//
//        return "";
//    }
}
