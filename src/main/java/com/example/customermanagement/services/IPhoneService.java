package com.example.customermanagement.services;

import com.example.customermanagement.entity.Phone;

import java.util.List;

/**
 * Created by Wellington Adames on 07/08/2021
 */
public interface IPhoneService {
    List<Phone> findByCustomerId(Long id);
    void deleteById(Long id);
    Phone create(Phone phone);
    Phone update(Phone phone);
}
