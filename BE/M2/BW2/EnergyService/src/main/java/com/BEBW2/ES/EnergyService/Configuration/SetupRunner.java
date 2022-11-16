package com.BEBW2.ES.EnergyService.Configuration;

import com.BEBW2.ES.EnergyService.Entities.*;
import com.BEBW2.ES.EnergyService.Services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(2)
public class SetupRunner implements CommandLineRunner {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SetupConfig.class);

    @Autowired
    RoleService rs;

    @Autowired
    UserService us;

    @Autowired
    AddressService as;

    @Autowired
    CustomerService custS;

    @Autowired
    InvoiceService is;

    @Override
    public void run(String... args) throws Exception {

        log.info("RUNNER SETUP START");

        createData();

        log.info("RUNNER SETUP END");

    }

    private void createData() {

//        rs.save(ctx.getBean("rAdmin", Role.class));
//        rs.save(ctx.getBean("rUser", Role.class));
//
//        us.save(ctx.getBean("user1", User.class));
//        us.save(ctx.getBean("user2", User.class));
//        us.save(ctx.getBean("user3", User.class));
//
//        as.save(ctx.getBean("address1", Address.class));
//
//        custS.save(ctx.getBean("customer1", Customer.class));
//
//        is.save(ctx.getBean("invoice1", Invoice.class));


    }
}
