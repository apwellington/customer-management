package com.example.customermanagement.config;

import com.example.customermanagement.entity.Address;
import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.services.IAddressService;
import com.example.customermanagement.services.ICustomerService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wellington Adames on 08/08/2021
 */
@Component
public class DataLoader implements ApplicationRunner {
    private ICustomerService customerService;
    private IAddressService iAddressService;

    public DataLoader(ICustomerService customerService, IAddressService iAddressService) {
        this.customerService = customerService;
        this.iAddressService = iAddressService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer customer = new Customer();
        Address address = new Address();
        address.setZipCode("10805");
        address.setRegion("Santo Domingo Oeste");
        address.setCountry("Santo Domingo");
        address.setName("Casa");
        address.setLineOne("Soldados de Jesucristo");
        address.setCustomer(customer);
        List<Address> addressList = new ArrayList<>();
        customer.setName("Wellington");
        customer.setEmail("well@well.com");
        customer.setPhone("8098867879");
        customer.setStatus(true);
        customer.setAddresses();

    }
}
