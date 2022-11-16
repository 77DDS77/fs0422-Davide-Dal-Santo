package com.BEBW2.ES.EnergyService.Services;

import com.BEBW2.ES.EnergyService.Entities.Customer;
import com.BEBW2.ES.EnergyService.Exceptions.ByIdNotFoundException;
import com.BEBW2.ES.EnergyService.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository cr;

    // method to save and persist in db a Customer entity
    public Customer save(Customer customer) {
        return cr.save(customer);
    }

    //simple get All customers, return an iterable of customers
    public Iterable<Customer> getAllCustomer() {
        return cr.findAll();
    }

    //simple get All customers, return a pageable of customers for lighter payloads
    public Page<Customer> getAllCustomerPageable(Pageable p) {
        return cr.findAll(p);
    }

    // easy find by id, if id is non-existent throws an exception
    public Customer findById(Long id) throws ByIdNotFoundException {
        Optional<Customer> found = cr.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        throw new ByIdNotFoundException("Customer", id);
    }

    //update, takes the ID of the "original" customer and a Customer object to get the props that we will
    //assign to the original, now updated, customer.
    public Customer update(Long id, Customer updtCustomer) throws ByIdNotFoundException {
        Customer origCustomer = findById(id);
        origCustomer.setRagioneSociale(updtCustomer.getRagioneSociale());
        origCustomer.setPartitaIVA(updtCustomer.getPartitaIVA());
        origCustomer.setEmail(updtCustomer.getEmail());
        origCustomer.setFatturatoAnnuale(updtCustomer.getFatturatoAnnuale());
        origCustomer.setPec(updtCustomer.getPec());
        origCustomer.setTelefono(updtCustomer.getTelefono());
        origCustomer.setEmailContatto(updtCustomer.getEmailContatto());
        origCustomer.setNomeContatto(updtCustomer.getNomeContatto());
        origCustomer.setCognomeContatto(updtCustomer.getCognomeContatto());
        origCustomer.setTelefonoContatto(updtCustomer.getTelefonoContatto());
        origCustomer.setSedeLegale(updtCustomer.getSedeLegale());
        origCustomer.setIndirizzoOpzionale(updtCustomer.getIndirizzoOpzionale());
        origCustomer.setTipo(updtCustomer.getTipo());

        cr.save(origCustomer);
        return origCustomer;
    }

    // delete a customer
    public String delete(Long id) {
        cr.deleteById(id);
        return "Customer deleted successfully.";
    }

    //----------------------------------------------------------

    // method to set the last contact with a customer
    public Customer updateLastContact(long id) throws ByIdNotFoundException {
        Customer found = findById(id);
        found.setDataUltimoContatto(LocalDate.now());
        return found;
    }

    //----------------------FILTERING METHODS-------------------

    //by fatturato annuale
    public List<Customer> findByFatturatoAnnuale(double fatturatoAnnuale) {
        return cr.findByFatturatoAnnuale(fatturatoAnnuale);
    }

    //by fatturato annuale greater or equal to input
    public List<Customer> findByFatturatoAnnualeGreaterThanEqual(double fatturatoAnnuale) {
        return cr.findByFatturatoAnnualeGreaterThanEqual(fatturatoAnnuale);
    }

    //by data inserimento
    public List<Customer> findByDataInserimento(LocalDate dataInserimento) {
        return cr.findByDataInserimento(dataInserimento);
    }

    //by data ultimo contatto
    public List<Customer> findByDataUltimoContatto(LocalDate dataUltimoContatto) {
        return cr.findByDataUltimoContatto(dataUltimoContatto);
    }

    //by nomeContatto o parte di nomeContatto
    public List<Customer> findByNomeContattoContainsIgnoreCase(String nomeContatto) {
        return cr.findByNomeContattoContainsIgnoreCase(nomeContatto);
    }
}
