package mum.edu.flightbooking.service;

import mum.edu.flightbooking.entity.Role;
import mum.edu.flightbooking.entity.User;

public interface RoleService {
    public Role findByRole(String roleName);
}
