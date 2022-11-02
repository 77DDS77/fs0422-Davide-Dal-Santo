package com.danieleterracciano.reservationmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.danieleterracciano.reservationmanager.entities.Workstation;
import com.danieleterracciano.reservationmanager.entities.WorkstationType;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Integer>{

	@Query(
		nativeQuery = true,
		value = "SELECT * FROM workstations WHERE WStype = :t AND city IN (SELECT city FROM buildings WHERE city = :c)"
	)
	public List<Workstation> findWorkstationsByCityAndWSType(@Param("c") String city, @Param("t") String t);
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM workstations WHERE WStype = :t"
		)
		public List<Workstation> findWorkstationByWSType(@Param("t") WorkstationType t);
	
	
}
