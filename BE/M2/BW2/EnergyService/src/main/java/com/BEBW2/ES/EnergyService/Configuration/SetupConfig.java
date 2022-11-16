package com.BEBW2.ES.EnergyService.Configuration;

import com.BEBW2.ES.EnergyService.Entities.*;
import com.BEBW2.ES.EnergyService.Services.ComuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;

import java.math.BigDecimal;
import java.util.Optional;

@Configuration
@Order(1)
public class SetupConfig {

//    @Autowired
//    private ComuneService cs;

    @Bean(name = "rAdmin")
    @Scope("singleton")
    public Role roleAdmin() {
        return new Role(RoleType.ROLE_ADMIN);
    }

    @Bean(name = "rUser")
    @Scope("singleton")
    public Role roleUser() {
        return new Role(RoleType.ROLE_USER);
    }

    @Bean(name = "user1")
    @Scope("singleton")
    public User user1() {
        User u = new User("ajeje", "Aldo", "Baglio", "dexter@garolfo.cops", "test");
        u.getRoles().add(roleAdmin());
        return u;
    }

    @Bean(name = "user2")
    @Scope("singleton")
    public User user2() {
        User u = new User("piera", "Giacomino", "Poretti", "sugar@garolfo.cops", "test");
        u.getRoles().add(roleUser());
        return u;
    }

    @Bean(name = "user3")
    @Scope("singleton")
    public User user3() {
        User u = new User("Pdor", "Giovanni", "Storti", "tiger@garolfo.cops", "test");
        u.getRoles().add(roleAdmin());
        u.getRoles().add(roleUser());
        return u;
    }

//    @Bean(name = "comune1")
//    @Scope("singleton")
//    public Comune comune1(){
//
//        Optional<Comune> c1 = cs.getByName("Vigonza");
//        if(c1.isPresent()){
//            return c1.get();
//        }else{
//            System.out.println("NON SEI NELL IF");
//            return null;
//        }
//
//    }
//
//
//    @Bean(name = "address1")
//    @Scope("prototype")
//    public Address address1(){
//        System.out.println("PRIMA");
//        Optional<Comune> c = cs.getByName("Vigonza");
//
//
//        if (c.isPresent()) {
//        //if(comune1() != null){
//
//            Address a = new Address(
//                    "Via Roma",
//                    15,
//                    35010,
//                    c.get()
//                    //comune1()
//            );
//            System.out.println("DOPO");
//
//            return a;
//        }
//
//        return null;
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Customer customer1() {
//
//        if(address1() != null) {
//
//            Customer c = new Customer(
//                    "Evergreen di Mario Rossi",
//                    "07643520567",
//                    "Evergreen@gmail.com",
//                    10000d,
//                    "Evergreen@alibaba.com",
//                    "3214567216",
//                    "SuperMario@gmail.com",
//                    "Mario",
//                    "Rossi",
//                    "3214796652",
//                    address1(),
//                    CompanyType.SRL
//            );
//
//            return  c;
//        }
//
//        return null;
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Invoice invoice1() {
//        return new Invoice(
//                new BigDecimal("1234.80"),
//                12,
//                customer1()
//        );
//    }

}
