package com.danieleterracciano.reservationmanager.controllers;

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

import com.danieleterracciano.reservationmanager.entities.Building;
import com.danieleterracciano.reservationmanager.entities.Workstation;
import com.danieleterracciano.reservationmanager.entities.WorkstationType;
import com.danieleterracciano.reservationmanager.services.BuildingService;
import com.danieleterracciano.reservationmanager.services.WorkstationService;

@RestController
@RequestMapping("/api")
public class WorkstationController {
	
	@Autowired
	WorkstationService ws;
	
	@Autowired
	BuildingService bs;
	
	//--------------- GET -------------------
	
	@GetMapping("/workstations/{id}")
	public Optional<Workstation> getWorkstationById(@PathVariable int id) {
		return ws.getWorkstationById(id);
	}
	
	@GetMapping("/workstations")
	public List<Workstation> getAllWorkstations(){
		return ws.getAllWorkstations();
	}
	//--------------- POST -------------------
	
	@PostMapping("/workstations")
	public Workstation postWorkstation(
			@RequestParam("WSType") WorkstationType WSType,
			@RequestParam("description") String description,
			@RequestParam("total_seats") int total_seats,		
			@RequestParam(name="building_id", required = false) Integer building_id
	) {
		
		if(building_id != null) {
			Optional<Building> b = bs.getBuildingById(building_id);
			
			if(b.isPresent() && b.get().getWorkstation() == null) {
				Workstation w = Workstation.builder()
						.WSType(WSType)
						.description(description)
						.totalSeats(total_seats)
						.building(b.get())
						.build();
				
				ws.saveWorkstation(w);
				return w;
			}		
		}
		Workstation w = Workstation.builder()
				.WSType(WSType)
				.description(description)
				.totalSeats(total_seats)
				.build();
		
		ws.saveWorkstation(w);
		return w;
	}
	//--------------- PUT -------------------
	
	@PutMapping("/workstations/{id}")
	public Workstation putWorkstation(
			@PathVariable("id") int id,
			@RequestParam(name="WSType", required = false) WorkstationType WSType,
			@RequestParam(name="description", required = false) String description,
			@RequestParam(name="total_seats", required = false) Integer total_seats,		
			@RequestParam(name="building_id", required = false) Integer building_id
	) {
		
		Optional<Workstation> workstation = getWorkstationById(id);
		
		if(workstation.isPresent()) {
			Workstation w = workstation.get();
			
			if(WSType != null) w.setWSType(WSType);
			if(description != null) w.setDescription(description);
			if(total_seats != null) w.setTotalSeats(total_seats);
			if(building_id != null) {
				Optional<Building> b = bs.getBuildingById(building_id);			
				
				if(b.isPresent() && b.get().getWorkstation() == null) w.setBuilding(b.get());		
			}
			
			ws.saveWorkstation(w);
			return w;		
		}
		
		return null;
	}
	
	//--------------- DELETE -------------------

	@DeleteMapping("/workstations/{id}")
	public Workstation deleteWorkstation(@PathVariable("id") int id) {
		
		Optional<Workstation> w = getWorkstationById(id);
		
		if(w.isPresent()) {
			ws.deleteWorkstationById(id);
			return w.get();
		}
		return null;
	}
}
