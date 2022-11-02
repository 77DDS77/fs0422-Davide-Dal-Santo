package com.danieleterracciano.reservationmanager.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.danieleterracciano.reservationmanager.ReservationManagerApplication;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	String username;
	String fullName;
	String email;
	
	@JsonBackReference
	@OneToMany(mappedBy = "user")
	Set<Reservation> reservations;
	
	public void addReservation(Reservation r) {
		Logger logger = LoggerFactory.getLogger(ReservationManagerApplication.class);
		if(reservations == null) reservations = new HashSet<Reservation>();
		
		if(reservations.add(r)) {
			reservations.add(r);
			logger.info("Reservation added successfully");
		} else {
			logger.error("Reservation is already present");
		}
	}
}
