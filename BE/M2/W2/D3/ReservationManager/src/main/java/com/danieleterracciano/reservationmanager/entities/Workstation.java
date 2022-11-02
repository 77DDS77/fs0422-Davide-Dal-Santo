package com.danieleterracciano.reservationmanager.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "workstations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Workstation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private WorkstationType WSType;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "building_id")
	private Building building;
	
	private String description;
	private int totalSeats;
	
	@JsonBackReference
	@OneToMany(mappedBy = "workstation")
	Set<Reservation> reservations;
	
	public boolean isOpen(Reservation r) {
		for(Reservation res : reservations) {
			if(res.getDate().isEqual(r.getDate())) return false;
		}
		return true;
	}
}
