package com.example.customermanagement.services;

import com.example.customermanagement.entity.Address;
import com.example.customermanagement.exceptions.AddressException;

import java.util.List;

/**
 * Created by Wellington Adames on 07/08/2021
 */
public interface IAddressService {

    List<Address> findByCustomerId(Long id) throws AddressException;
    List<Address> findAll() throws AddressException;
    Address findById(Long id)  throws AddressException;
    void deleteById(Long id)  throws AddressException;
    Address create(Address address)  throws AddressException;
    Address update(Address address) throws AddressException;
}
