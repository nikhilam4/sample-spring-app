package com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.requests;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationRequest {

	private Long Id;

	private Long roomId;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate Checkin;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate Checkout;

	public ReservationRequest() {
		super();
	}

	public ReservationRequest(Long roomId, LocalDate checkin, LocalDate checkout) {
		super();
		this.roomId = roomId;
		Checkin = checkin;
		Checkout = checkout;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public Long getId() {
		return Id;
	}

	public void setCheckin(LocalDate checkin) {
		this.Checkin = checkin;
	}

	public LocalDate getCheckin() {
		return this.Checkin;
	}

	public void setCheckout(LocalDate checkout) {
		Checkout = checkout;
	}

	public LocalDate getCheckout() {
		return Checkout;
	}
}
