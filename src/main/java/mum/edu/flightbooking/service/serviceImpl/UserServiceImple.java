package mum.edu.flightbooking.service.serviceImpl;

import mum.edu.flightbooking.entity.User;
import mum.edu.flightbooking.repository.UserRepository;
import mum.edu.flightbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User signUpMethod(User theUser) {
        if(userRepository.findByEmail(theUser.getEmail())!=null){
            System.out.println("the user already exist");
            return null;
        }
        return userRepository.save(theUser);
    }
}
