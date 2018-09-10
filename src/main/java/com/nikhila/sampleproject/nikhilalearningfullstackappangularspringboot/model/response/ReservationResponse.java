package com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.model.response;

import java.time.LocalDate;

public class ReservationResponse {

	private Long Id;

	private LocalDate CheckIn;

	private LocalDate CheckOut;

	public ReservationResponse() {
		super();
	}

	public ReservationResponse(Long id, LocalDate checkIn, LocalDate checkOut) {
		super();
		Id = id;
		CheckIn = checkIn;
		CheckOut = checkOut;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public LocalDate getCheckIn() {
		return CheckIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		CheckIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return CheckOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		CheckOut = checkOut;
	}
}
