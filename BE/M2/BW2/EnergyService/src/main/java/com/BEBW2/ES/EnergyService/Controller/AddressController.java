package com.BEBW2.ES.EnergyService.Controller;

import com.BEBW2.ES.EnergyService.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    AddressService as;
}
