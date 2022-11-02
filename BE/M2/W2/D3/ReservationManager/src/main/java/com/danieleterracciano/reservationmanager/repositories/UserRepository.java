package com.danieleterracciano.reservationmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danieleterracciano.reservationmanager.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
