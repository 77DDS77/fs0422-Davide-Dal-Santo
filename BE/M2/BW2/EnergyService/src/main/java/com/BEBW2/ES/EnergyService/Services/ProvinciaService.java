package com.BEBW2.ES.EnergyService.Services;

import com.BEBW2.ES.EnergyService.Entities.Provincia;
import com.BEBW2.ES.EnergyService.Exceptions.ByIdNotFoundException;
import com.BEBW2.ES.EnergyService.Repositories.ProvinciaRepository;
import com.BEBW2.ES.EnergyService.helper.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository pr;

    public List<Provincia> getAll() {
        return pr.findAll();
    }

    public Page<Provincia> getAllPaginate(Pageable p) {
        return pr.findAll(p);
    }

    public Provincia getById(Long id) throws ByIdNotFoundException {
        Optional<Provincia> found = pr.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        throw new ByIdNotFoundException("Provincia", id);
    }


    public Optional<Provincia> getByName(String provincia) {
        return pr.findByName(provincia);
    }

    public void saveAll(String file) {
        try {
            List<Provincia> provincie = CSVHelper.csvToProvincie(file);
            pr.saveAll(provincie);
        } catch (Exception e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public void delete(Long id) throws Exception {
        Optional<Provincia> p = pr.findById(id);
        if (p.isPresent()) {
            pr.delete(p.get());
        } else {
            throw new Exception("Utente non trovato");
        }
    }

    public void update(Provincia p) {
        pr.save(p);
    }
}
