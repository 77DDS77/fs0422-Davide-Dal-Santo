package Banca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Banca.entity.BankAccount;
import Banca.exceptions.NotFoundException;
import Banca.repositories.BankAccountRepository;

@Service
public class BankAccountService {

	@Autowired
	BankAccountRepository repository;
	
	public BankAccount save(BankAccount x) {
		return repository.save(x);
	}

	public List<BankAccount> getAll() {
		return repository.findAll();
	}

	public BankAccount getById(Long id){
		Optional<BankAccount> ba = repository.findById(id);
		if (!ba.isPresent())
			throw new NotFoundException("Account not available");
		return ba.get();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Page<BankAccount> getAllPaginate(Pageable p) {
		return repository.findAll(p);
	}
	
}
