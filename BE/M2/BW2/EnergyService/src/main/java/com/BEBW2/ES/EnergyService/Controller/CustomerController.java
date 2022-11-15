package com.BEBW2.ES.EnergyService.Controller;

import com.BEBW2.ES.EnergyService.Entities.Customer;
import com.BEBW2.ES.EnergyService.Exceptions.ByIdNotFoundException;
import com.BEBW2.ES.EnergyService.Services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService cs;

    //----------------------GET-------------------
    /*
    * Three way to get the customer list:
    * - via iterable variable
    * - via pageable to manage large numbers of customers
    * - via Customer's ID
    * */
    @GetMapping("")
    public ResponseEntity<Iterable<Customer>> getAllCustomers(){
        return new ResponseEntity<>(cs.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Customer>> getPageableCustomers(Pageable p){
        Page<Customer> foundAll = cs.getAllCustomerPageable(p);
        if(foundAll.hasContent()){
            return new ResponseEntity<>(foundAll, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        try{
            return new ResponseEntity<>(cs.findById(id), HttpStatus.OK);
        } catch (ByIdNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //----------------------POST-------------------

    /*
    * Endpoint to post a new Customer:
    * - must receive a complete customer obj as Request Body
    * */
    @PostMapping("/new")
    public ResponseEntity<Customer> createNewCustomer(@RequestBody  Customer customer){
        try{
            return new ResponseEntity<>(cs.save(customer), HttpStatus.OK);
        }catch(Exception e){
            log.error("Error saving customer: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //----------------------PUT-------------------
    /*
     * Endpoint to update a Customer:
     * - must receive the id of the "Original" Customer
     * - must receive a complete customer obj as Request Body
     * */
    //TODO vedere se serve @RequestBody sui parametri
    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(Long id, Customer UpdatedCustomer){
        try {
            return new ResponseEntity<>(cs.update(id, UpdatedCustomer), HttpStatus.OK);
        } catch (ByIdNotFoundException e) {
            log.error("Error updating customer: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //----------------------DELETE-------------------
    /*
     * Endpoint to delete a Customer:
     * - must receive the id of the Customer you want to delete
     * */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try{
            return new ResponseEntity<>(cs.delete(id), HttpStatus.OK);
        }catch(IllegalArgumentException iae){
            log.error("Error deleting Customer (id could be null): " + iae.getMessage());
            return new ResponseEntity<>(iae.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //----------------------ACTIONS-------------------
    @PutMapping("/{id}/update-last-contact")
    public ResponseEntity<Customer> updateLastContact(@PathVariable Long id){
        try{
            return new ResponseEntity<>(cs.updateLastContact(id), HttpStatus.OK);
        } catch (ByIdNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
