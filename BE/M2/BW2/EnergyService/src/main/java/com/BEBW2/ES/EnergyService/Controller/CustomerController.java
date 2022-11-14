package com.BEBW2.ES.EnergyService.Controller;

import com.BEBW2.ES.EnergyService.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService cs;
}
