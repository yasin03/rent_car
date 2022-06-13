package com.backend.rentcar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.backend.rentcar.domain.User;
import com.backend.rentcar.exception.BadRequestException;
import com.backend.rentcar.exception.ConflictException;
import com.backend.rentcar.exception.ResourceNotFoundException;
import com.backend.rentcar.projection.ProjectUser;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email) throws ResourceNotFoundException;
	
	Boolean existsByEmail(String email) throws ConflictException;
	
	List<ProjectUser> findAllBy();
	
	@Transactional
	@Modifying
	@Query("UPDATE User u " +
            "SET u.firstName = ?2, u.lastName = ?3, u.phoneNumber = ?4, u.email = ?5, u.address = ?6, " +
            "u.zipCode = ?7 WHERE u.id = ?1")
	void update (Long id, String firstName, String lastName, String phoneNumber, String email,
			String address, String zipCode) throws BadRequestException;
	
	
}
