package com.davidedalsanto.Lezione4.repositories;

import java.util.List;

import com.davidedalsanto.Lezione4.entities.User;

public interface UserRepository {
	
	//quanti utenti nella tabella
	public int count();
	
	public int save(User user, long address_id);
	
	public int update(User user);
	
	public int deleteById(long id);
	
	public List<User> getAll();
	
	public User findById(long id);
}
