package com.danieleterracciano.reservationmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieleterracciano.reservationmanager.entities.User;
import com.danieleterracciano.reservationmanager.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository ur;
	
	public void saveUser(User u) {
		ur.save(u);
	}
	
	public void deleteUserById(int id) {
		ur.deleteById(id);
	}
	
	public Optional<User> getUserById(int id) {
		return ur.findById(id);
	}
	
	public List<User> getAllUsers(){
		return ur.findAll();
	}
}
