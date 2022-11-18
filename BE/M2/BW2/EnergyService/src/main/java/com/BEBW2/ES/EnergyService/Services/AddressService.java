package com.BEBW2.ES.EnergyService.Services;

import com.BEBW2.ES.EnergyService.Entities.Address;
import com.BEBW2.ES.EnergyService.Entities.Comune;
import com.BEBW2.ES.EnergyService.Exceptions.ByIdNotFoundException;
import com.BEBW2.ES.EnergyService.Exceptions.ComuneNotFoundException;
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

    @Autowired
    ComuneService cs;

    public Address save(String via, int civico, int cap, String comune) throws ComuneNotFoundException {
        Comune c = cs.getByName(comune);
        if (c != null) {
            Address a = new Address(via, civico, cap, c);
            ar.save(a);
            return a;
        }else{
            throw new ComuneNotFoundException(comune);
        }
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

    /**
     * Check if the Address given already exists in the database
     * */
    public Optional<Address> getSameAddress(Address a) {
        return ar.getSameAddress(a.getCap(), a.getVia(), a.getCivico());
    }

}
