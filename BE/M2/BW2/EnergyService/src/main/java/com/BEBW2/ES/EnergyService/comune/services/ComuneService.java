package com.BEBW2.ES.EnergyService.comune.services;


import com.BEBW2.ES.EnergyService.comune.model.Comune;
import com.BEBW2.ES.EnergyService.comune.repositories.ComuneRepository;
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

    public Optional<Comune> getById(Long id) {
        return cr.findById(id);
    }

    public Optional<Comune> getByName(String comune) {
        return cr.findByName(comune);
    }

    public void save(Comune c) {
        cr.save(c);
    }

    public void delete(Long id) throws Exception {
        Optional<Comune> c = cr.findById(id);
        if(c.isPresent()) {
            cr.delete(c.get());
        } else {
            throw new Exception("Utente non trovato");
        }
    }

    public void update(Comune c) {
        cr.save(c);
    }
}
