package mum.edu.flightbooking.service.serviceImpl;

import mum.edu.flightbooking.entity.Role;
import mum.edu.flightbooking.entity.User;
import mum.edu.flightbooking.repository.RoleRepository;
import mum.edu.flightbooking.repository.UserRepository;
import mum.edu.flightbooking.service.RoleService;
import mum.edu.flightbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImple implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Role findByRole(String roleName) {
        return roleRepository.findByRole(roleName);
    }
}
