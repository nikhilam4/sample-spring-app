package com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.converter.ReservationEntityToReservationResponseConverter;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.converter.ReservationRequestToReservationEntityConverter;
import com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.converter.RoomEntityToReservableRoomResponseConverter;

@Configuration
public class ConversionConfig {
	private Set<Converter> getConverter() {
		Set<Converter> converters = new HashSet<Converter>();
		converters.add(new RoomEntityToReservableRoomResponseConverter());
		converters.add(new ReservationRequestToReservationEntityConverter());
		converters.add(new ReservationEntityToReservationResponseConverter());
		return converters;
	}
	
	@Bean
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverter());
		bean.afterPropertiesSet();
		return bean.getObject();
	}

}
