package com.davidedalsanto.AD.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.davidedalsanto.AD.exceptions.UpdateException;
import com.davidedalsanto.AD.exceptions.UserNotFoundException;
import com.davidedalsanto.AD.models.User;
import com.davidedalsanto.AD.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo ur;
	
	public Iterable<User> searchAllUsers() {
		return ur.findAll();
	}
	
	public Page<User> searchAllUsersPageable(Pageable p) {
		return ur.findAll(p);
	}

	public User create(User user) {
		return ur.save(user);
	}

	public User findById(long id) throws UserNotFoundException {
		User found =  ur.findById(id).get();
		if(found != null) {
			return found;
		}else {
			throw new UserNotFoundException();
		}
	}

	public User update(Long id, User user) throws UpdateException {
		Optional<User> userRes = ur.findById(id);

		if (userRes.isPresent()) {
			User userUp = userRes.get();
			userUp.setName(user.getName());
			userUp.setEmail(user.getEmail());
			ur.save(userUp);
			return userUp;
		} else {
			throw new UpdateException();
		}

	}
	
	
	public void delete(long id) {
		ur.deleteById(id);
	}
}
