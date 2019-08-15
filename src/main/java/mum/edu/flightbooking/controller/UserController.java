package mum.edu.flightbooking.controller;

import mum.edu.flightbooking.dto.BookDTO;
import mum.edu.flightbooking.dto.LogInDTO;
import mum.edu.flightbooking.entity.Booking;
import mum.edu.flightbooking.entity.Flight;
import mum.edu.flightbooking.entity.User;
import mum.edu.flightbooking.service.BookingService;
import mum.edu.flightbooking.service.FlightService;
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
    @Autowired
    private FlightService flightService;

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

    @GetMapping("/flightNumber")
    public String getLogInPage(@RequestParam("flightId") Long flightId,Model theModel){
        LogInDTO logInDTO=new LogInDTO();
        logInDTO.setFlightId(flightId);
        theModel.addAttribute("loginDTO",logInDTO);
        System.out.println("==============================getLogInPage Id"+flightId);
        theModel.addAttribute("aaa",flightId);
        return "bookingForm";
    }
    @PostMapping("/flightNumber")
    public String postLogInPage(@ModelAttribute("loginDTO") LogInDTO logInDTO,RedirectAttributes redirectAttributes){
        Booking theBooking=new Booking();
//        System.out.println("==============================postLogInPage Id"+logInDTO.getFlightId());
//        User theUser=userService.findByEmail(logInDTO.getEmail());
        User theUser=new User();
        theUser.setDob(logInDTO.getDob());
        theUser.setFirstName(logInDTO.getfName());
        theUser.setLastName(logInDTO.getlName());
        theUser.setGender(logInDTO.getGender());
        theUser.setEmail(logInDTO.getEmail());
        theUser.setPassword(logInDTO.getPassword());
        userService.save(theUser);
        theBooking.setFlight(flightService.findById(logInDTO.getFlightId()));
//        if (!theUser.getPassword().equals(logInDTO.getPassword())){
//            return "redirect:/user/incorectpage";
//        }
        User temp=userService.findByEmail(logInDTO.getEmail());
        theBooking.setUser(temp);
        redirectAttributes.addFlashAttribute("usertocomfirm",bookingService.save(theBooking));

        // bookingService.save(theBooking);
        return "redirect:/user/comfirmation";
    }
    @GetMapping("/comfirmation")
    public String comfirmationMethod(Model model){
//        Booking booking= (Booking) model.asMap().get("usertocomfirm");
        return "user/comfirmationPage";
    }
}
