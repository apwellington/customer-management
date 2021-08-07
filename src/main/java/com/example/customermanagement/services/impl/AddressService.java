package com.example.customermanagement.services.impl;

import com.example.customermanagement.entity.Address;
import com.example.customermanagement.repository.AddressRepository;
import com.example.customermanagement.services.IAddressService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Wellington Adames on 07/08/2021
 */
@Service
public class AddressService  implements IAddressService{

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public List<Address> findByCustomerId(Long id) {
        return Optional.of(this.addressRepository.findByCustomerIdAndStatusIsTrue(id)).orElse(new ArrayList<>());
    }

    @Override
    public void findById(Long id) {
        this.addressRepository.deleteById(id);
    }

    @Override
    public Address create(Address address) {
        return Optional.of(this.addressRepository.save(address)).orElse(new Address());
    }

    @Override
    public Address update(Address address) {
        Address old = this.addressRepository.getById(address.getId());
        old.setName(address.getName());
        old.setLineOne(address.getLineOne());
        old.setLineTwo(address.getLineTwo());
        old.setCity(address.getCity());
        old.setRegion(address.getRegion());
        old.setCountry(address.getCountry());
        old.setZipCode(address.getZipCode());
        return Optional.of(this.addressRepository.save(address)).orElse(new Address());
    }
}
