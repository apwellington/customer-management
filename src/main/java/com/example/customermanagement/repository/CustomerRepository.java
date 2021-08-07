package com.example.customermanagement.repository;

import com.example.customermanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByNameAndStatusIsTrue(String name);
    List<Customer> findByLastNameAndStatusIsTrue(String lastName);
    Customer findByEmailAndStatusIsTrue(String email);
    Customer findByIdAndStatusIsTrue(Long id);

    @Query("UPDATE Customer c set c.status = 0 where c.id = :id")
    void deleteById(@Param("id") Long id);
}
