package com.example.customermanagement.services.impl;

import com.example.customermanagement.entity.Address;
import com.example.customermanagement.exceptions.AddressException;
import com.example.customermanagement.repository.AddressRepository;
import com.example.customermanagement.services.IAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Wellington Adames on 07/08/2021
 */
@Service
public class AddressService  implements IAddressService{

    private final Logger logger = LoggerFactory.getLogger(AddressService.class);
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public List<Address> findByCustomerId(Long id)  throws AddressException {
        try{
            logger.debug(String.format("findByCustomerId(%s)", id));
            return Optional.of(this.addressRepository.findByCustomerIdAndStatusIsTrue(id)).get();
        }catch (Exception e){
            e.printStackTrace();
            throw new AddressException(e);
        }

    }

    @Override
    public Address findById(Long id) throws AddressException {
        try{
            logger.debug(String.format("findById(%s)", id));
            return this.addressRepository.findById(id).get();
        }catch (Exception e){
            e.printStackTrace();
            throw new AddressException(e);
        }

    }

    @Override
    public void deleteById(Long id) throws AddressException {
        try{
            logger.debug(String.format("deleteById(%s)", id));
            this.addressRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new AddressException(e);
        }

    }

    @Override
    public Address create(Address address) throws AddressException {
        try{
            logger.debug(String.format("create(%s)", address.toString()));
            return Optional.of(this.addressRepository.save(address)).get();
        }catch (Exception e){
            e.printStackTrace();
            throw new AddressException(e);
        }
    }

    @Override
    public Address update(Address address) throws AddressException {
        try{
            logger.debug(String.format("update(%s)", address.toString()));
            Address old = this.addressRepository.getById(address.getId());
            old.setName(address.getName());
            old.setLineOne(address.getLineOne());
            old.setLineTwo(address.getLineTwo());
            old.setCity(address.getCity());
            old.setRegion(address.getRegion());
            old.setCountry(address.getCountry());
            old.setZipCode(address.getZipCode());
            return Optional.of(this.addressRepository.save(address)).get();
        }catch (Exception e){
            e.printStackTrace();
            throw new AddressException(e);
        }
    }
}
