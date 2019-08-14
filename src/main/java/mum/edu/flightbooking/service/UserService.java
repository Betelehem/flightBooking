package mum.edu.flightbooking.service;

import mum.edu.flightbooking.entity.User;

public interface UserService {
    User save(User theUser);
    User findByEmail(String email);
}
