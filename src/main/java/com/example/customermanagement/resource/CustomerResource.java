package com.example.customermanagement.resource;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exceptions.CustomerException;
import com.example.customermanagement.resource.dto.CustomerDto;
import com.example.customermanagement.resource.dto.Response;
import com.example.customermanagement.services.ICustomerService;
import com.example.customermanagement.util.GenericMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by Wellington Adames on 07/08/2021
 */
@RestController
@RequestMapping("/customer")
public class CustomerResource extends AbstractResource<CustomerDto, Long>{
    Logger logger = LoggerFactory.getLogger(CustomerResource.class);

    private final ModelMapper modelMapper;
    private final ICustomerService customerService;
    public CustomerResource(ModelMapper modelMapper, ICustomerService customerService) {
        logger.info("init CustomerResource");
        this.modelMapper = modelMapper;
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<Response> create(@RequestBody CustomerDto customerDto, Response response) {
        Customer customerEntity = GenericMapper.map(customerDto, Customer.class, modelMapper);
        try {
            CustomerDto customerDtoRes = GenericMapper.map(this.customerService.create(customerEntity), CustomerDto.class, modelMapper);
            response.response.put("data", customerDtoRes);
            response.response.put("message", HttpStatus.OK.getReasonPhrase());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (CustomerException ex){
            ex.printStackTrace();
            response.response.put("data", customerDto);
            response.response.put("message", ex.getMessage());
            response.response.put("error", true);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Response> delete(@PathVariable Long id, Response response) {
        try {
            this.customerService.delete(id);
            response.response.put("data", 1);
            response.response.put("message", HttpStatus.OK.getReasonPhrase());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomerException e) {
            e.printStackTrace();
            response.response.put("data", 0);
            response.response.put("message", e.getMessage());
            response.response.put("error", true);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Response> update(@RequestBody CustomerDto customerDto, @PathVariable Long aLong, Response response) {
        Customer customerEntity = GenericMapper.map(customerDto, Customer.class, modelMapper);
        try {
            CustomerDto customerDtoRes = GenericMapper.map(this.customerService.update(customerEntity), CustomerDto.class, modelMapper);
            response.response.put("data", customerDtoRes);
            response.response.put("message", HttpStatus.OK.getReasonPhrase());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (CustomerException ex){
            ex.printStackTrace();
            response.response.put("data", customerDto);
            response.response.put("message", ex.getMessage());
            response.response.put("error", true);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    public ResponseEntity<Response> findAll(Response response){
        try{
            List<CustomerDto> customers = GenericMapper.mapCollection(customerService.findAll(), CustomerDto.class, modelMapper);
            response.response.put("data", customers);
            response.response.put("message", HttpStatus.OK.getReasonPhrase());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (CustomerException ex){
            ex.printStackTrace();
            response.response.put("message", ex.getMessage());
            response.response.put("error", true);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Response> findById(@PathVariable Long id, Response response) {
        try {
            logger.debug(String.format("indById(%s)", id));
            CustomerDto customerDto = GenericMapper.map(customerService.findById(id), CustomerDto.class, modelMapper);
            response.response.put("data", customerDto);
            response.response.put("message", HttpStatus.OK.getReasonPhrase());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomerException e) {
            e.printStackTrace();
            response.response.put("message", e.getMessage());
            response.response.put("error", true);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
