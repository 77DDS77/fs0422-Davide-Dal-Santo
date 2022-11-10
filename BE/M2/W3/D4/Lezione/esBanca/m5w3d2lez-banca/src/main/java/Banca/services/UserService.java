package Banca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Banca.entity.User;
import Banca.exceptions.NotFoundException;
import Banca.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private UserRepository repository;

	public void save(User u) {
		String psw = u.getPassword();
		u.setPassword(encoder.encode(psw));
		repository.save(u);
	}

	public List<User> getAll() {
		return repository.findAll();
	}

	public User getById(Long id) {
		Optional<User> user = repository.findById(id);
		if (!user.isPresent())
			throw new NotFoundException("User not available");
		return user.get();
	}

	public void delete(Long id) throws Exception {
		Optional<User> u = repository.findById(id);
		if (u.isPresent()) {
			repository.delete(u.get());
		} else {
			throw new Exception("Utente non trovato");
		}
	}

	public void update(User u) {
		repository.save(u);
	}

	public User findByUsername(String username) {
		Optional<User> user = repository.findByUsername(username);
		if (!user.isPresent())
			throw new NotFoundException("No user with that username found");
		return user.get();
	}

	public Page<User> getAllPaginate(Pageable p) {
		return repository.findAll(p);
	}
}