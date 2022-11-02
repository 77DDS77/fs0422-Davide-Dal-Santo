package com.danieleterracciano.reservationmanager.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danieleterracciano.reservationmanager.entities.Reservation;
import com.danieleterracciano.reservationmanager.entities.User;
import com.danieleterracciano.reservationmanager.entities.Workstation;
import com.danieleterracciano.reservationmanager.services.ReservationService;
import com.danieleterracciano.reservationmanager.services.UserService;
import com.danieleterracciano.reservationmanager.services.WorkstationService;

@RestController
@RequestMapping("/api")
public class ReservationControl {

	@Autowired
	ReservationService rs;
	
	@Autowired
	UserService us;
	
	@Autowired
	WorkstationService ws;
	
	//--------------- GET -------------------
	
	@GetMapping("/reservations/{id}")
	public Optional<Reservation> getReservationById(@PathVariable("id") int id) {
		return rs.getReservationById(id);
	}
	
	@GetMapping("/reservations")
	public List<Reservation> getAllReservations(){
		return rs.getAllReservations();
	}
	//--------------- POST -------------------
	
	@PostMapping("/reservations")
	public Reservation postReservation(
			@RequestParam("date") LocalDate date,
			@RequestParam("user_id") int user_id,
			@RequestParam("workstation_id") int workstation_id
	) {
		List<Reservation> reservations = getAllReservations();
		Optional<User> u = us.getUserById(user_id);
		Optional<Workstation> w = ws.getWorkstationById(workstation_id);
		
		for(Reservation r : reservations){
			if(r.getDate().isEqual(date)) return null;
		}
		
		if (u.isPresent() && w.isPresent()) {
			return Reservation.builder()
					.date(date)
					.user(u.get())
					.workstation(w.get())
					.build();
		}
		return null;
	}
	//--------------- PUT -------------------
	
	@PutMapping("/reservations/{id}")
	public Reservation putReservation(
			@PathVariable("id") int id,
			@RequestParam(name="date", required = false) LocalDate date,
			@RequestParam(name="user_id", required = false) Integer user_id,
			@RequestParam(name="workstation_id", required = false) Integer workstation_id
	) {
		
		List<Reservation> reservations = getAllReservations();
		Optional<Reservation> r = getReservationById(id);
		
		for(Reservation re : reservations){
			if(re.getDate().isEqual(date)) return null;
		}
		
		if(r.isPresent()) {
			Reservation res = r.get();
			if(date != null) res.setDate(date);
			if(user_id != null) {
				Optional<User> u = us.getUserById(user_id);
				if(u.isPresent()) res.setUser(u.get());
			}
			if(workstation_id != null) {
				Optional<Workstation> w = ws.getWorkstationById(workstation_id);
				if(w.isPresent()) res.setWorkstation(w.get());
			}
			rs.saveReservation(res);
		}
		return null;
	}
	//--------------- DELETE -------------------
	@DeleteMapping("/reservations/{id}")
	public Reservation deleteReservation(@PathVariable("id") int id) {
		
		Optional<Reservation> r = getReservationById(id);
		if(r.isPresent()) {
			rs.deleteReservationById(id);
			return r.get();
		}
		return null;
	}
}
