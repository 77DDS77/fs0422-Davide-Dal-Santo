package com.BEBW2.ES.EnergyService.Controller;

import com.BEBW2.ES.EnergyService.Entities.Comune;
import com.BEBW2.ES.EnergyService.Exceptions.ByIdNotFoundException;
import com.BEBW2.ES.EnergyService.Exceptions.ComuneNotFoundException;
import com.BEBW2.ES.EnergyService.Services.ComuneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/comuni")
@CrossOrigin(origins = "http://localhost:4200/")
public class ComuneController {

    @Autowired
    ComuneService comS;

    //----------------------GET-------------------
    /*
     * Three way to get the Comune list:
     * - via iterable variable
     * - via pageable to manage large numbers of Comuni
     * - via Comune's ID
     * */
    @GetMapping("")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Iterable<Comune>> getAllComuni(){
        return new ResponseEntity<>(comS.getAll(), HttpStatus.OK);
    }

    @GetMapping("/pageable")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Page<Comune>> getPageableComuni(Pageable p){
        Page<Comune> foundAll = comS.getAllPaginate(p);

        if(foundAll.hasContent()){
            return new ResponseEntity<>(foundAll, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Comune> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(comS.getById(id), HttpStatus.OK);
        } catch (ByIdNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/comune")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Comune> findByName(@RequestParam() String comune) {
        try {
            return new ResponseEntity<>(comS.getByName(comune), HttpStatus.OK);
        } catch (ComuneNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/provincia")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<Comune>> findByProvincia(@RequestParam() String provincia) {
            return new ResponseEntity<>(comS.getByProvincia(provincia), HttpStatus.OK);

    }
}
