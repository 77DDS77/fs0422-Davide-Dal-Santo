package com.danieleterracciano.reservationmanager.services;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class LocalDateConverter implements Converter<String, LocalDate>{

	@Override
	public LocalDate convert(String source) {	
		return LocalDate.parse(source);
	}

}
