package com.backend.rentcar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.rentcar.domain.Role;
import com.backend.rentcar.domain.enumaration.UserRole;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(UserRole name);
}
