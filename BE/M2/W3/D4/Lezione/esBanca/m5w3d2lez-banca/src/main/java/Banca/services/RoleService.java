package Banca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Banca.entity.Role;
import Banca.entity.RoleType;
import Banca.exceptions.NotFoundException;
import Banca.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository repository;

	public Role save(Role x) {
		return repository.save(x);
	}
	
	public Page<Role> getAllPaginate(Pageable p) {
		return repository.findAll(p);
	}

	public List<Role> getAll() {
		return repository.findAll();
	}

	public Role getById(Long id) {
		Optional<Role> ba = repository.findById(id);
		if (!ba.isPresent())
			throw new NotFoundException("Role not available");
		return ba.get();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Role getByRole(RoleType roleType) {		
		Optional<Role> ba = repository.findByRoleType(roleType);
		if (!ba.isPresent())
			throw new NotFoundException("Role not available");
		return ba.get();
	}
}
