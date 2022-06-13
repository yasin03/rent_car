package com.backend.rentcar.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.rentcar.domain.Car;
import com.backend.rentcar.domain.Reservation;
import com.backend.rentcar.domain.User;
import com.backend.rentcar.domain.enumaration.ReservationStatus;
import com.backend.rentcar.dto.ReservationDTO;

@Repository
@Transactional(readOnly = true)
public interface ReservationRepository {
	
	boolean existsByUserId(User user);
	
	boolean existByCarId(Car car);
	
	@Transactional
	@Query("SELECT new com.backend.rentcar.dto.ReservationDTO(r) FROM Reservation r")
	List<ReservationDTO> findAllReservation();
	
	@Transactional
	@Query("SELECT new com.backend.rentcar.dto.ReservationDTO(r) FROM Reservation r "
			+ "WHERE r.id =?1 and r.userId.id =?2")
	List<ReservationDTO> findUserReservationsById(Long id, Long userId);
	
	@Transactional
	@Query("SELECT new com.backend.rentcar.dto.ReservationDTO(r) FROM Reservation r WHERE r.id =?1")
	Optional<ReservationDTO> findReservationById(Long id);
	
	@Transactional
	@Query("SELECT new com.backend.rentcar.dto.ReservationDTO(r) FROM Reservation r "
			+ "WHERE r.id =?1 and r.userId.id =?2")
	Optional<ReservationDTO> findReservationByUserId(Long id, Long userId);
	
	
	@Transactional
	@Query("SELECT new com.backend.rentcar.dto.ReservationDTO(r) FROM Reservation r WHERE r.userId.id =?1")
	List<ReservationDTO> findReservationByUserId(Long userId);
	
	@Transactional
	@Query("SELECT r FROM Reservation r LEFT JOIN fetch r.carId cd LEFT JOIN fetch cd.image img"
			+ "LEFT JOIN fetch r.userId uid WHERE "
			+ "(cd.id = ?1 and r.status <> ?4 and r.status <> ?5 and ?2 BETWEEN r.pickUpTime and r.dropOfTime) or " 
			+ "(cd.id = ?1 and r.status <> ?4 and r.status <> ?5 and ?3 BETWEEN r.pickUpTime and r.dropOfTime)")
	List<Reservation> checkStatus(Long carId, LocalDateTime pickUpTime, LocalDateTime dropOffTime,
			ReservationStatus done, ReservationStatus canceled);
	

}
