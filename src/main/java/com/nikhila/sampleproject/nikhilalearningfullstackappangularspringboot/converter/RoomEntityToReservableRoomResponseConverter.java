package com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.entity.RoomEntity;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.model.Links;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.model.Self;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.model.response.ReservableRoomResponse;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.rest.ResourceConstants;

@Component
public class RoomEntityToReservableRoomResponseConverter implements Converter<RoomEntity, ReservableRoomResponse>   {

	@Override
	public ReservableRoomResponse convert(RoomEntity source) {
		ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice(Integer.valueOf(source.getPrice()));
		
		if(null != source.getId()) {
			reservationResponse.setId(source.getId());
		}
		
		Links links = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
		links.setSelf(self);
		reservationResponse.setLinks(links);
		return reservationResponse;
	}

}
