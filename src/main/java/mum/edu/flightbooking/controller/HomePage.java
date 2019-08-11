package mum.edu.flightbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

    @GetMapping(path = {"/","/home"})
    public String homePage(){
        return "home";
    }


}
