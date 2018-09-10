package com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.rest;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.converter.RoomEntityToReservableRoomResponseConverter;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.entity.ReservationEntity;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.entity.RoomEntity;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.model.response.ReservableRoomResponse;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.model.response.ReservationResponse;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.repository.PageableRoomRepository;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.repository.ReservationRepository;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.repository.RoomRepository;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.requests.ReservationRequest;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
@CrossOrigin
public class ReservationResource {

	@Autowired
	PageableRoomRepository pageableRoomRepository;

	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	ConversionService conversionService;

	@Autowired
	RoomEntityToReservableRoomResponseConverter roomEntityToReservationResponseConverter;

	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ReservableRoomResponse> getAvailableRooms(
			@RequestParam(value = "checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
			@RequestParam(value = "checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout,
			Pageable pageable) {

		Page<RoomEntity> roomEntities = pageableRoomRepository.findAll(pageable);
		return roomEntities.map(roomEntityToReservationResponseConverter::convert);
	}

	@RequestMapping(path = "/{roomId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RoomEntity> getRoomById(@PathVariable Long roomId) {

		Optional<RoomEntity> roomEntiy = roomRepository.findById(roomId);

		if(roomEntiy.isPresent()) {
			return new ResponseEntity<>(roomEntiy.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationRequest reservationRequest) {
		
		ReservationEntity reservationEntity = conversionService.convert(reservationRequest, ReservationEntity.class);
		reservationRepository.save(reservationEntity);
		
		RoomEntity roomEntity = roomRepository.findById(reservationRequest.getRoomId()).get();
		roomEntity.addReservationEntity(reservationEntity);
		roomRepository.save(roomEntity);
		reservationEntity.setRoomEntity(roomEntity);
		
		ReservationResponse reservationResponse = conversionService.convert(reservationEntity, ReservationResponse.class);
		
		return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservableRoomResponse> updateReservation(@RequestBody ReservationRequest reservationRequest) {
		return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReservation(@PathVariable long reservationId) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
