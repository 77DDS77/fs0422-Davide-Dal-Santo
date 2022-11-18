package com.BEBW2.ES.EnergyService.Controller;

import com.BEBW2.ES.EnergyService.Entities.Address;
import com.BEBW2.ES.EnergyService.Exceptions.ByIdNotFoundException;
import com.BEBW2.ES.EnergyService.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin(origins = "http://localhost:4200/")
public class AddressController {

    @Autowired
    AddressService as;

    //----------------------GET-------------------
    /*
     * Three way to get the Address list:
     * - via iterable variable
     * - via pageable to manage large numbers of Addresses
     * - via Address's ID
     * */
    @GetMapping("")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Iterable<Address>> getAllAddresses() {
        return new ResponseEntity<>(as.getAll(), HttpStatus.OK);
    }

    @GetMapping("/pageable")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Page<Address>> getPageableAddress(Pageable p) {
        Page<Address> foundAll = as.getAllPaginate(p);

        if (foundAll.hasContent()) {
            return new ResponseEntity<>(foundAll, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Address> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(as.getById(id), HttpStatus.OK);
        } catch (ByIdNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
