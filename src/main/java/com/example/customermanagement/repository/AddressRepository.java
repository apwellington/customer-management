package com.example.customermanagement.repository;

import com.example.customermanagement.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("SELECT a FROM Address a WHERE a.customer.id = :id")
    List<Address> findByCustomerIdAndStatusIsTrue(@Param("id") Long id);

    @Query("UPDATE Address a set a.status = 0 where a.id = :id")
    void deleteById(@Param("id") Long id);
}
