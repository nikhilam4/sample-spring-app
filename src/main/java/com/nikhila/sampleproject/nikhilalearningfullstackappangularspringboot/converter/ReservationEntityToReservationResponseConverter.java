package com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.converter;

import org.springframework.core.convert.converter.Converter;

import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.entity.ReservationEntity;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.model.response.ReservationResponse;

public class ReservationEntityToReservationResponseConverter implements Converter<ReservationEntity, ReservationResponse> {

	@Override
	public ReservationResponse convert(ReservationEntity source) {

		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setCheckIn(source.getCheckIn());
		reservationResponse.setCheckOut(source.getCheckOut());
		
		if(null != source.getId()) {
			reservationResponse.setId(source.getId());
		}
		
		return reservationResponse;
	}

}
