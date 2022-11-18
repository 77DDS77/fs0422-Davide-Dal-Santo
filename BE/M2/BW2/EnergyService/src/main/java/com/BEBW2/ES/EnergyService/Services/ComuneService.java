package com.BEBW2.ES.EnergyService.Services;


import com.BEBW2.ES.EnergyService.Entities.Comune;
import com.BEBW2.ES.EnergyService.Exceptions.ByIdNotFoundException;
import com.BEBW2.ES.EnergyService.Exceptions.ComuneNotFoundException;
import com.BEBW2.ES.EnergyService.Repositories.ComuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComuneService {

    @Autowired
    private ComuneRepository cr;

    public List<Comune> getAll() {
        return cr.findAll();
    }

    public Page<Comune> getAllPaginate(Pageable p) {
        return cr.findAll(p);
    }

    public Comune getById(Long id) throws ByIdNotFoundException {
        Optional<Comune> found = cr.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        throw new ByIdNotFoundException("Comune", id);
    }

    public Comune getByName(String comune) throws ComuneNotFoundException{

        Optional<Comune> found =  cr.findByName(comune);

        if (found.isPresent()) {
            return found.get();
        }
        throw new ComuneNotFoundException(comune);
    }

    public List<Comune> getByProvincia(String provincia){
        return cr.findByProvincia(provincia);
    }


    public void save(Comune c) {
        cr.save(c);
    }

    public void saveAll(List<Comune> lc) {
        cr.saveAll(lc);
    }

    public void delete(Long id) throws Exception {
        Optional<Comune> c = cr.findById(id);
        if(c.isPresent()) {
            cr.delete(c.get());
        } else {
            throw new Exception("Comune non trovato");
        }
    }

    public void update(Comune c) {
        cr.save(c);
    }

}
