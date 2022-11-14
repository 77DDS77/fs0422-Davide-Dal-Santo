package com.BEBW2.ES.EnergyService.Services;

import com.BEBW2.ES.EnergyService.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository cr;
}
