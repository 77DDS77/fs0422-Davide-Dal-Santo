package com.BEBW2.ES.EnergyService.Controller;

import com.BEBW2.ES.EnergyService.Entities.Customer;
import com.BEBW2.ES.EnergyService.Entities.Invoice;
import com.BEBW2.ES.EnergyService.Entities.InvoiceState;
import com.BEBW2.ES.EnergyService.Exceptions.ByIdNotFoundException;
import com.BEBW2.ES.EnergyService.Exceptions.CantModifyInvoiceException;
import com.BEBW2.ES.EnergyService.Exceptions.InvalidInvoiceStateException;
import com.BEBW2.ES.EnergyService.Services.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    InvoiceService is;

    //----------------------GET-------------------
    /*
     * Three way to get the Invoices list:
     * - via iterable variable
     * - via pageable to manage large numbers of customers
     * - via Invoice's ID
     * */
    @GetMapping("")
    public ResponseEntity<Iterable<Invoice>> getAllCustomers(){
        return new ResponseEntity<>(is.getAllInvoices(), HttpStatus.OK);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Invoice>> getPageableInvoices(Pageable p){
        Page<Invoice> foundAll = is.getAllInvoicesPageable(p);
        if(foundAll.hasContent()){
            return new ResponseEntity<>(foundAll, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> findById(@PathVariable Long id){
        try{
            return new ResponseEntity<>(is.getById(id), HttpStatus.OK);
        } catch (ByIdNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //----------------------POST-------------------

    /*
     * Endpoint to post a new Invoice:
     * - must receive a complete Invoice obj as Request Body
     * */
    @PostMapping("/new")
    public ResponseEntity<Invoice> createNewCustomer(@RequestBody Invoice invoice){
        try{
            return new ResponseEntity<>(is.save(invoice), HttpStatus.OK);
        }catch(Exception e){
            log.error("Error saving customer: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //----------------------PUT-------------------
    /*
     * Endpoint to update an Invoice:
     * - must receive the id of the "Original" Invoice
     * - must receive a complete Invoice obj as Request Body
     * */
    //TODO vedere se serve @RequestBody sui parametri
    @PutMapping("/update")
    public ResponseEntity<Invoice> updateCustomer(Long id, Invoice UpdatedInvoice){
        try {
            return new ResponseEntity<>(is.update(id, UpdatedInvoice), HttpStatus.OK);
        } catch (ByIdNotFoundException e) {
            log.error("Error updating customer: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (CantModifyInvoiceException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //----------------------DELETE-------------------
    /*
     * Endpoint to delete an Invoice:
     * - must receive the id of the Invoice you want to delete
     * */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try{
            return new ResponseEntity<>(is.delete(id), HttpStatus.OK);
        }catch(IllegalArgumentException iae){
            log.error("Error deleting Invoice (id could be null): " + iae.getMessage());
            return new ResponseEntity<>(iae.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //----------------------ACTIONS-------------------

    //endpoint to change the state of the Invoice to ACCETTATA following the conditions
    //set on the acceptInvoice method of the InvoiceService
    @PutMapping("/{id}/accept")
    public ResponseEntity<Invoice> acceptInvoice(@PathVariable Long id){
        try{
            return new ResponseEntity<>(is.acceptInvoice(id), HttpStatus.OK);
        } catch (InvalidInvoiceStateException | ByIdNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //endpoint to change the state of the Invoice to RIFIUTATA following the conditions
    //set on the denyInvoice method of the InvoiceService
    @PutMapping("/{id}/deny")
    public ResponseEntity<Invoice> denyInvoice(@PathVariable Long id){
        try{
            return new ResponseEntity<>(is.denyInvoice(id), HttpStatus.OK);
        } catch (InvalidInvoiceStateException | ByIdNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //endpoint to change the state of the Invoice to the param sent with the request
    //TODO check se RequestParam va bene o no
    @PutMapping("/{id}/state-change")
    public ResponseEntity<Invoice> changeStatus(@PathVariable Long id, @RequestParam InvoiceState newState){
        try{
            return new ResponseEntity<>(is.changeStatus(id, newState), HttpStatus.OK);
        } catch (ByIdNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }







}
