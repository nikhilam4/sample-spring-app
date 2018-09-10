package com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Reservation")
public class ReservationEntity {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@NotNull
	private LocalDate CheckIn;

	@NotNull
	private LocalDate CheckOut;
	
	@ManyToOne
	private RoomEntity RoomEntity;

	public ReservationEntity() {
		super();
	}

	public ReservationEntity(LocalDate checkIn, LocalDate checkOut) {
		this.CheckIn = checkIn;
		this.CheckOut = checkOut;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public LocalDate getCheckIn() {
		return CheckIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.CheckIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return CheckOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.CheckOut = checkOut;
	}

	public RoomEntity getRoomEntity() {
		return RoomEntity;
	}

	public void setRoomEntity(RoomEntity roomEntity) {
		RoomEntity = roomEntity;
	}

}
