package com.BEBW2.ES.EnergyService.Services;

import com.BEBW2.ES.EnergyService.Entities.Address;
import com.BEBW2.ES.EnergyService.Exceptions.ByIdNotFoundException;
import com.BEBW2.ES.EnergyService.Repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository ar;

    public void save(Address r) {
        ar.save(r);
    }

    public List<Address> getAll() {
        return ar.findAll();
    }

    public Page<Address> getAllPaginate(Pageable p) {
        return ar.findAll(p);
    }

    public Address getById(Long id) throws ByIdNotFoundException {
        Optional<Address> found = ar.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        throw new ByIdNotFoundException("Address", id);

    }

    public Address update(Address a) {

        ar.save(a);

        return a;
    }


    public String delete(Long id) {

        ar.deleteById(id);

        return "Address deleted successfully.";

    }

}
