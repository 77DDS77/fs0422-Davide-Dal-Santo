package com.danieleterracciano.reservationmanager.configs;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.danieleterracciano.reservationmanager.entities.Building;
import com.danieleterracciano.reservationmanager.entities.Reservation;
import com.danieleterracciano.reservationmanager.entities.User;
import com.danieleterracciano.reservationmanager.entities.Workstation;
import com.danieleterracciano.reservationmanager.entities.WorkstationType;

@Configuration
public class Config {

	@Bean
	@Scope("prototype")
	public User getPino() {
		return User.builder()
				.username("DarthPino")
				.fullName("Pino Insegno")
				.email("pinsegno@gmail.com")
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public User getGino() {
		return User.builder()
				.username("JediGino")
				.fullName("Gino Paoli")
				.email("ginetto.paoletto@gmail.com")
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public User getLino() {
		return User.builder()
				.username("MasterLino")
				.fullName("Lino Banfi")
				.email("linonelpallone@gmail.com")
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Building getCasaMia() {
		return Building.builder()
				.address("Via Qui 1")
				.city("Milano")
				.name("Casa Mia")
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Building getCasaTua() {
		return Building.builder()
				.address("Via Lì 1")
				.city("Roma")
				.name("Casa Tua")
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Building getCasaSua() {
		return Building.builder()
				.address("Via Dall'altra parte 1")
				.city("Napoli")
				.name("Casa Sua")
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Workstation getWS1() {
		return Workstation.builder()
				.WSType(WorkstationType.MEETING_ROOM)
				.building(getCasaMia())
				.description("E' proprio casa mia")
				.totalSeats(10)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Workstation getWS2() {
		return Workstation.builder()
				.WSType(WorkstationType.OPENSPACE)
				.building(getCasaTua())
				.description("Fai come se fossi a casa tua")
				.totalSeats(15)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Workstation getWS3() {
		return Workstation.builder()
				.WSType(WorkstationType.PRIVATE)
				.building(getCasaSua())
				.description("Non ci sono mai stato")
				.totalSeats(100)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Reservation getReservation1() {
		return Reservation.builder()
				.user(getGino())
				.workstation(getWS1())
				.date(LocalDate.of(2023, 1, 15))
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Reservation getReservation2() {
		return Reservation.builder()
				.user(getPino())
				.workstation(getWS2())
				.date(LocalDate.of(2022, 12, 15))
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Reservation getReservation3() {
		return Reservation.builder()
				.user(getLino())
				.workstation(getWS3())
				.date(LocalDate.of(2022, 11, 15))
				.build();
	}
}
