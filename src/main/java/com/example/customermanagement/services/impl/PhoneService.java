package com.example.customermanagement.services.impl;

import com.example.customermanagement.entity.Phone;
import com.example.customermanagement.repository.PhoneRepository;
import com.example.customermanagement.services.IPhoneService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Wellington Adames on 07/08/2021
 */
@Service
public class PhoneService implements IPhoneService {

    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public List<Phone> findByCustomerId(Long id) {
        return Optional.of(this.phoneRepository.findByCustomerIdAndStatusIsTrue(id)).orElse(new ArrayList<>());
    }

    @Override
    public void deleteById(Long id) {
        this.phoneRepository.deleteById(id);
    }

    @Override
    public Phone create(Phone phone) {
        return Optional.of(this.phoneRepository.save(phone)).orElse(new Phone());
    }

    @Override
    public Phone update(Phone phone) {
        Phone old = this.phoneRepository.getById(phone.getId());
        old.setPhoneName(phone.getPhoneName());
        old.setPhoneNumber(phone.getPhoneNumber());
        return Optional.of(this.phoneRepository.save(old)).orElse(new Phone());
    }
}
