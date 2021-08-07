package com.example.customermanagement.repository;

import com.example.customermanagement.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
