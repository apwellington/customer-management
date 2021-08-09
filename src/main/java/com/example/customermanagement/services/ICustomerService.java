package com.example.customermanagement.services;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exceptions.CustomerException;

import java.util.List;

/**
 * Created by Wellington Adames on 06/08/2021
 */
public interface ICustomerService {
    Customer findById(Long id)throws CustomerException;
    List<Customer> findAll() throws CustomerException;
    List<Customer> findByName(String name) throws CustomerException;
    List<Customer> findByLastName(String lastName) throws CustomerException;
    Customer findByEmail(String email) throws CustomerException;
    Customer create(Customer customer) throws CustomerException;
    Customer update(Customer customer) throws CustomerException;
    void delete(Long id) throws CustomerException;
}
