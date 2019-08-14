package mum.edu.flightbooking.repository;

import mum.edu.flightbooking.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    public Role findByRole(String roleName);
}
