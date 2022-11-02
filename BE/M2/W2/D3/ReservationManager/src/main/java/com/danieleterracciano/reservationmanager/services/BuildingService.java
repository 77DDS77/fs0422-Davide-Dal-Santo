package com.danieleterracciano.reservationmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieleterracciano.reservationmanager.entities.Building;
import com.danieleterracciano.reservationmanager.repositories.BuildingRepository;

@Service
public class BuildingService {

	@Autowired
	BuildingRepository br;
	
	public void saveBuilding(Building b) {
		br.save(b);
	}
	
	public Optional<Building> getBuildingById(int id) {
		return br.findById(id);
	}
	
	public List<Building> getAllBuildings(){
		return br.findAll();
	}
	
	public void deleteBuildingById(int id) {
		br.deleteById(id);
	}
	
	public List<Building> getBuildingByCity(String c){
		return br.findBuildingByCity(c);
	}
}
