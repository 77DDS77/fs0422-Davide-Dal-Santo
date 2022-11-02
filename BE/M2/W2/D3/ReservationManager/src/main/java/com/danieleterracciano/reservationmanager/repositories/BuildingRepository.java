package com.danieleterracciano.reservationmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.danieleterracciano.reservationmanager.entities.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer>{

	@Query(
		nativeQuery = true,
		value = "SELECT * FROM buildings WHERE buildings.city LIKE :c"
	)
	public List<Building> findBuildingByCity(@Param("c") String c);
}
