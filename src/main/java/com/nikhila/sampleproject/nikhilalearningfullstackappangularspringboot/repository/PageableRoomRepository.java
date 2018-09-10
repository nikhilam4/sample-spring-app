package com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.entity.RoomEntity;

public interface PageableRoomRepository extends PagingAndSortingRepository<RoomEntity, Long> {

	Page<RoomEntity> findById(Long id, Pageable page);

}
