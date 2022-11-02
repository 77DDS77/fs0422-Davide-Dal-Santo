package com.danieleterracciano.reservationmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danieleterracciano.reservationmanager.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
