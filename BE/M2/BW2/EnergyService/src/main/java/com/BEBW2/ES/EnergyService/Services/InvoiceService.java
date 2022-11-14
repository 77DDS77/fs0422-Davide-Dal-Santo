package com.BEBW2.ES.EnergyService.Services;

import com.BEBW2.ES.EnergyService.Repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository ir;
}
