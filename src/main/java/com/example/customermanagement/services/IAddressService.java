package com.example.customermanagement.services;

import com.example.customermanagement.entity.Address;
import java.util.List;

/**
 * Created by Wellington Adames on 07/08/2021
 */
public interface IAddressService {
    List<Address> findByCustomerId(Long id);
    void findById(Long id);
    Address create(Address address);
    Address update(Address address);
}
