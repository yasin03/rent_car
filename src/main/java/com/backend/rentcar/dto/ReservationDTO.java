package com.backend.rentcar.dto;

import java.time.LocalDateTime;

import com.backend.rentcar.domain.Reservation;
import com.backend.rentcar.domain.enumaration.ReservationStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

	private Long id;
	
	private CarDTO car;
	
	private Long userId;
	
	private LocalDateTime pickUpTime;
	
	private LocalDateTime dropOfTime;
	
	private String pickUpLocation;
	
	private String dropOfLocation;
	
	private ReservationStatus status;
	
	private Double totalPrice;
	
    public ReservationDTO(Reservation reservation) {
        this.id = reservation.getId();
        this.car = new CarDTO(reservation.getCarId());
        this.userId = reservation.getUserId().getId();
        this.pickUpTime = reservation.getPickUpTime();
        this.dropOfTime = reservation.getDropOfTime();
        this.pickUpLocation = reservation.getPickUpLocation();
        this.dropOfLocation = reservation.getDropOfLocation();
        this.status = reservation.getStatus();
        this.totalPrice = reservation.getTotalPrice();
        
    }
	
}
