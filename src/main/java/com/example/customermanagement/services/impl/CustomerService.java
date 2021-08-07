package com.example.customermanagement.services.impl;
import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.repository.CustomerRepository;
import com.example.customermanagement.services.ICustomerService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Wellington Adames on 06/08/2021
 */
@Service
class CustomerService implements ICustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(Long id) {
        return Optional.of(this.customerRepository.findByIdAndStatusIsTrue(id)).orElse(new Customer());
    }

    @Override
    public List<Customer> findAll() {
        return Optional.of(this.customerRepository.findAll()).orElse(new ArrayList<Customer>());
    }

    @Override
    public List<Customer> findByName(String name) {
        return Optional.of(this.customerRepository.findByNameAndStatusIsTrue(name)).orElse(new ArrayList<Customer>());
    }

    @Override
    public List<Customer> findLastName(String lastName) {
        return Optional.of(this.customerRepository.findByLastNameAndStatusIsTrue(lastName)).orElse(new ArrayList<Customer>());
    }

    @Override
    public Customer findByEmail(String email) {
        return Optional.of(this.customerRepository.findByEmailAndStatusIsTrue(email)).orElse(new Customer());
    }

    @Override
    public Customer create(Customer customer) {
        return Optional.of(this.customerRepository.save(customer)).orElse(new Customer());
    }

    @Override
    public Customer update(Customer customer) {
        Customer old = this.customerRepository.findById(customer.getId()).get();
        old.setAddresses(customer.getAddresses());
        old.setEmail(customer.getEmail());
        old.setName(customer.getName());
        old.setLastName(customer.getLastName());
        old.setPhones(customer.getPhones());
        return this.customerRepository.save(old);
    }

    @Override
    public void delete(Long id) {
        this.customerRepository.deleteById(id);
    }
}
