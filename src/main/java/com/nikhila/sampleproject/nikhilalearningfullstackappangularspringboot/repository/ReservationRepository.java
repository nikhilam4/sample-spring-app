package com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.entity.ReservationEntity;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long>{

}
