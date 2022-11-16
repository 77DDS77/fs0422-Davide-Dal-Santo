package com.BEBW2.ES.EnergyService.Controller;

import com.BEBW2.ES.EnergyService.Entities.Address;
import com.BEBW2.ES.EnergyService.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    AddressService as;

    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Iterable<Address>> getAllAddresses(){
        return new ResponseEntity<>(as.getAll(), HttpStatus.OK);
    }

    @GetMapping("/pageable")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Page<Address>> getPageableAddress(Pageable p){
        Page<Address> foundAll = as.getAllPaginate(p);

        if(foundAll.hasContent()){
            return new ResponseEntity<>(foundAll, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
