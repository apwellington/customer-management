package com.example.customermanagement.services;

import com.example.customermanagement.entity.Customer;

import java.util.List;

/**
 * Created by Wellington Adames on 06/08/2021
 */
public interface ICustomerService {
    //Find
    Customer findById(Long id);
    List<Customer> findAll();
    List<Customer> findByName(String name);
    List<Customer> findLastName(String lastName);
    Customer findByEmail(String email);

    //create
    Customer create(Customer customer);

    //update
    Customer update(Customer customer);

    //delete
    void delete(Long id);
}
