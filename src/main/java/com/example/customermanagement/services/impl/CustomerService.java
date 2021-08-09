package com.example.customermanagement.services.impl;
import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exceptions.CustomerException;
import com.example.customermanagement.repository.CustomerRepository;
import com.example.customermanagement.services.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Created by Wellington Adames on 06/08/2021
 */
@Service
class CustomerService implements ICustomerService {

    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(Long id)throws CustomerException {
        try{
            logger.debug(String.format("findById(%s)", id));
            return Optional.ofNullable(this.customerRepository.findByIdAndStatusIsTrue(id)).get();
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomerException(e);
        }

    }

    @Override
    public List<Customer> findAll() throws CustomerException {
        try{
            logger.debug(String.format("findAll()"));
            return Optional.of(this.customerRepository.findAll()).get();
        }catch (Exception e){
            e.printStackTrace();
            throw  new CustomerException(e);
        }

    }

    @Override
    public List<Customer> findByName(String name)throws CustomerException {
        try{
            logger.debug(String.format("findByName(%s)", name));
            return Optional.of(this.customerRepository.findByNameAndStatusIsTrue(name)).get();
        }catch (Exception e){
            e.printStackTrace();
            throw  new CustomerException(e);
        }

    }

    @Override
    public List<Customer> findByLastName(String lastName)throws CustomerException {
        try {
            logger.debug(String.format("findByLastName(%s)", lastName));
            return Optional.ofNullable(this.customerRepository.findByLastNameAndStatusIsTrue(lastName)).get();
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomerException(e);
        }
    }

    @Override
    public Customer findByEmail(String email)throws CustomerException {
        try {
            logger.debug(String.format("findByEmail(%s)", email));
            return Optional.ofNullable(this.customerRepository.findByEmailAndStatusIsTrue(email)).get();
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomerException(e);
        }
    }

    @Override
    public Customer create(Customer customer)throws CustomerException {
        try {
            logger.debug(String.format("create(%s)", customer.toString()));
            return Optional.of(this.customerRepository.save(customer)).get();
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomerException(e);
        }
    }

    @Override
    public Customer update(Customer customer)throws CustomerException {
        try{
            logger.debug(String.format("update(%s)", customer.toString()));
            Customer old = this.customerRepository.findById(customer.getId()).get();
            old.setAddresses(customer.getAddresses());
            old.setEmail(customer.getEmail());
            old.setName(customer.getName());
            old.setLastName(customer.getLastName());
            old.setPhone(customer.getPhone());
            return this.customerRepository.save(old);
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomerException(e);
        }

    }

    @Override
    public void delete(Long id) throws CustomerException {
        try{
            logger.debug(String.format("delete(%s)", id));
            this.customerRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomerException(e);
        }
    }
}
