package com.BEBW2.ES.EnergyService.Controller;

import com.BEBW2.ES.EnergyService.Entities.Customer;
import com.BEBW2.ES.EnergyService.Exceptions.ByIdNotFoundException;
import com.BEBW2.ES.EnergyService.Exceptions.ComuneNotFoundException;
import com.BEBW2.ES.EnergyService.Services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    CustomerService cs;

    //----------------------GET-------------------
    /**
     * Three-way to get the customer list:
     * - via iterable variable
     * - via pageable to manage large numbers of customers
     * - via Customer's ID
     * */
    @GetMapping("")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        return new ResponseEntity<>(cs.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/pageable")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Page<Customer>> getPageableCustomers(Pageable p) {
        Page<Customer> foundAll = cs.getAllCustomerPageable(p);
        if (foundAll.hasContent()) {
            return new ResponseEntity<>(foundAll, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(cs.findById(id), HttpStatus.OK);
        } catch (ByIdNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //----------------------POST-------------------

    /**
     * Endpoint to post a new Customer:
     * - must receive a complete customer obj as Request Body
     * */
    @PostMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer customer) {
        try {
            return new ResponseEntity<>(cs.save(customer), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error saving customer: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (ComuneNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //----------------------PUT-------------------
    /**
     * Endpoint to update a Customer:
     * - must receive the id of the "Original" Customer
     * - must receive a complete customer obj as Request Body
     * */
    //TODO vedere se serve @RequestBody sui parametri
    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer UpdatedCustomer) {
        try {
            System.err.println(UpdatedCustomer);
            return new ResponseEntity<>(cs.update(UpdatedCustomer), HttpStatus.OK);
        } catch (ByIdNotFoundException | ComuneNotFoundException e) {
            log.error("Error updating customer: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //----------------------DELETE-------------------
    /**
     * Endpoint to delete a Customer:
     * - must receive the id of the Customer you want to delete
     * */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(cs.delete(id), HttpStatus.OK);
        } catch (IllegalArgumentException iae) {
            log.error("Error deleting Customer (id could be null): " + iae.getMessage());
            return new ResponseEntity<>(iae.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //----------------------ACTIONS-------------------
    @PutMapping("/{id}/update-last-contact")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Customer> updateLastContact(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(cs.updateLastContact(id), HttpStatus.OK);
        } catch (ByIdNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //----------------------SORTED ENDPOINTS-------------------

    //SORT BY NOMECONTATTO
    @GetMapping("/pageable/sort-by-name")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Page<Customer>> getBySortedName(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        Pageable p = PageRequest.of(page, size, Sort.by("nomeContatto").ascending());
        Page<Customer> foundAll = cs.getAllCustomerPageable(p);
        if (foundAll.hasContent()) {
            return new ResponseEntity<>(foundAll, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //SORT BY FATTURATO ANNUALE
    @GetMapping("/pageable/sort-by-fatturato")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Page<Customer>> getBySortedFatturato(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        Pageable p = PageRequest.of(page, size, Sort.by("fatturatoAnnuale").descending());
        Page<Customer> foundAll = cs.getAllCustomerPageable(p);
        if (foundAll.hasContent()) {
            return new ResponseEntity<>(foundAll, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //SORT BY DATA ULTIMO CONTATTO
    @GetMapping("/pageable/sort-by-ultimo-contatto")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Page<Customer>> getBySortedUltimoContatto(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        Pageable p = PageRequest.of(page, size, Sort.by("dataUltimoContatto").descending());
        Page<Customer> foundAll = cs.getAllCustomerPageable(p);
        if (foundAll.hasContent()) {
            return new ResponseEntity<>(foundAll, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //SORT BY PROVINCIA SEDE LEGALE
    //todo vedere se sta cosa e' cosi' stupida che potrebbe funzionare
    @GetMapping("/pageable/sort-by-provincia")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Page<Customer>> getBySortedProvincia(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        Pageable p = PageRequest.of(page, size, Sort.by("sedeLegale.comune.provincia"));
        Page<Customer> foundAll = cs.getAllCustomerPageable(p);
        if (foundAll.hasContent()) {
            return new ResponseEntity<>(foundAll, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //----------------------FILTERED ENDPOINTS-------------------

    //Filter by fatturato annuale, strict value (search for customers with the specified value only)
    @GetMapping("/filtered/fatturato-annuale/{fatturato}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<Customer>> getByFatturatoAnnuale(@PathVariable(name = "fatturato") double fatturato) {
        try {
            return new ResponseEntity<>(cs.findByFatturatoAnnuale(fatturato), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //Filter by fatturato annuale (search for customers with the fatturatoAnnuale value from the specified value)
    @GetMapping("/filtered/fatturato-annuale-from/{fatturato}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<Customer>> findByFatturatoAnnualeGreaterThanEqual(@PathVariable(name = "fatturato") double fatturato) {
        try {
            return new ResponseEntity<>(cs.findByFatturatoAnnualeGreaterThanEqual(fatturato), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //Filter by data d'inserimento
    @GetMapping("/filtered/data-inserimento/{yyyy}/{mm}/{gg}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<Customer>> findByDataInserimento(@PathVariable(name = "yyyy") int year,
                                                                @PathVariable(name = "mm") int month,
                                                                @PathVariable(name = "gg") int day) {
        try {
            LocalDate dataInserimento = LocalDate.of(year, month, day);
            return new ResponseEntity<>(cs.findByDataInserimento(dataInserimento), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //Filter by data ultimo contatto
    @GetMapping("/filtered/data-ultimo-contatto/{yyyy}/{mm}/{gg}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<Customer>> findByDataUltimoContatto(@PathVariable(name = "yyyy") int year,
                                                                   @PathVariable(name = "mm") int month,
                                                                   @PathVariable(name = "gg") int day) {
        try {
            LocalDate dataUltimoContatto = LocalDate.of(year, month, day);
            return new ResponseEntity<>(cs.findByDataUltimoContatto(dataUltimoContatto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //Filter by nome contatto or partial of it
    @GetMapping("/filtered/nome-contatto")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<Customer>> findByNomeContatto(@RequestParam() String nomeContatto) {
        try {
            return new ResponseEntity<>(cs.findByNomeContattoContainsIgnoreCase(nomeContatto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}
