package com.BEBW2.ES.EnergyService.Controller;

import com.BEBW2.ES.EnergyService.Entities.Provincia;
import com.BEBW2.ES.EnergyService.Exceptions.ByIdNotFoundException;
import com.BEBW2.ES.EnergyService.Services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/provincie")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProvinciaController {

    @Autowired
    ProvinciaService ps;

    //----------------------GET-------------------
    /*
     * Three way to get the Provincia list:
     * - via iterable variable
     * - via pageable to manage large numbers of Provincie
     * - via Provincia's ID
     * */
    @GetMapping("")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Iterable<Provincia>> getAllComuni(){
        return new ResponseEntity<>(ps.getAll(), HttpStatus.OK);
    }

    @GetMapping("/pageable")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Page<Provincia>> getPageableComuni(Pageable p){
        Page<Provincia> foundAll = ps.getAllPaginate(p);

        if(foundAll.hasContent()){
            return new ResponseEntity<>(foundAll, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Provincia> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(ps.getById(id), HttpStatus.OK);
        } catch (ByIdNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
