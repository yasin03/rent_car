package com.backend.rentcar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.rentcar.domain.Car;
import com.backend.rentcar.dto.CarDTO;
import com.backend.rentcar.exception.ResourceNotFoundException;

@Repository
@Transactional(readOnly = true)
public interface CarRepository {

	@Transactional
	@Query("SELECT new com.backend.rentcar.dto.CarDTO(c) FROM Car c")
	List<CarDTO> findAllCar();
	
	@Transactional
	@Query("SELECT new com.backend.rentcar.dto.CarDTO(c) FROM Car c WHERE c.id = ?1")
	Optional<CarDTO> findCarByIdx(Long id) throws ResourceNotFoundException;
	
	@Transactional
	@Query("SELECT c FROM Car c LEFT JOIN fetch c.image img WHERE c.id =?1")
	Optional<Car> findCarById(Long id) throws ResourceNotFoundException;
	
	
}
