package Banca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Banca.entity.Payment;
import Banca.exceptions.NotFoundException;
import Banca.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository repository;
	
	public Payment save(Payment x) {
		return repository.save(x);
	}

	public List<Payment> getAll() {
		return repository.findAll();
	}

	public Payment getById(Long id){
		Optional<Payment> ba = repository.findById(id);
		if (!ba.isPresent())
			throw new NotFoundException("Payment not available");
		return ba.get();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Page<Payment> getAllPaginate(Pageable p) {
		return repository.findAll(p);
	}
}
