package com.example.customermanagement.repository;

import com.example.customermanagement.entity.Address;
import com.example.customermanagement.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    @Query("SELECT p FROM Phone p WHERE p.customer.id = :id")
    List<Phone> findByCustomerIdAndStatusIsTrue(@Param("customerId") Long id);

    @Query("UPDATE Phone p set p.status = 0 where p.id = :id")
    void deleteById(@Param("id") Long id);
}
