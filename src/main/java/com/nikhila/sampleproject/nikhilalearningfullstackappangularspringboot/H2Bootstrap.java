package com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.entity.RoomEntity;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.repository.RoomRepository;

@Component
public class H2Bootstrap implements CommandLineRunner{

	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Bootstrapping data .....");
		
		roomRepository.save(new RoomEntity(100, "2000" ));
		roomRepository.save(new RoomEntity(101, "2010" ));
		roomRepository.save(new RoomEntity(102, "2020" ));

		Iterable<RoomEntity>  rooms = roomRepository.findAll();
		
		System.out.println("Printing data .....");
		
		for(RoomEntity room : rooms) {
			System.out.println(room.getRoomNumber());
		}
		
	}

}
