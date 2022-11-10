package Banca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Banca.entity.BankAccount;
import Banca.entity.Payment;
import Banca.entity.User;
import Banca.exceptions.NotAllowedException;
import Banca.services.BankAccountService;
import Banca.services.PaymentService;
import Banca.services.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private BankAccountService bas;

	@Autowired
	private PaymentService ps;

	@Autowired
	private UserService us;

	@GetMapping("")
	public List<Payment> getAllPayments() {
		return ps.getAll();
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Payment>> getAllPageable(Pageable p) {
		Page<Payment> findAll = ps.getAllPaginate(p);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Payment> getById(@PathVariable Long id) {

		return new ResponseEntity<>(ps.getById(id), HttpStatus.OK);

	}

	@PostMapping("/new")
	public void create(
			@RequestParam("user_id") Long userId,
			@RequestParam("bankAccount_id") Long bankAccountId,
			@RequestParam("deposit") int deposit) {
		
			BankAccount ba = bas.getById(bankAccountId);
			User u = us.getById(userId);
			
			if(ba.getUsers().contains(u)) {
				Payment p = new Payment(u,ba,deposit);
			
			ba.updateBalance(deposit);
			bas.save(ba);
			ps.save(p);
			}else {
				throw new NotAllowedException("l'utente non ha i permessi per effettuare questa transazione");
			}
			
			
	}

//	@PutMapping("")
//	public void update(@RequestBody Payment payment) {
//		try {
//			ps.save(payment);
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteById(@PathVariable Long id) {
		try {
			ps.deleteById(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}