package mum.edu.flightbooking.controller;

import mum.edu.flightbooking.entity.User;
import mum.edu.flightbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/sign")
    public String getSignUp(Model theModel){
        User theUser = new User();
        theModel.addAttribute("user", theUser);

        return "user/signup";
    }

    @PostMapping("/sign")
    public String postSignUp(@ModelAttribute("user") User theUser){

        theUser.setAdmin(false);
        userService.signUpMethod(theUser);

        return "redirect:/home";
    }
}
