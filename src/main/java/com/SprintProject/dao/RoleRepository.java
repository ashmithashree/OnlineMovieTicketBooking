package com.SprintProject.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.SprintProject.entities.Role;
import com.SprintProject.entities.Roles;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByRoleName(Roles role);
}
