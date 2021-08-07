package com.example.customermanagement.resource;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.resource.dto.CustomerDto;
import com.example.customermanagement.services.ICustomerService;
import com.example.customermanagement.util.GenericMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Created by Wellington Adames on 07/08/2021
 */
@RestController
@RequestMapping("/customer")
public class CustomerResource {
    Logger logger = LoggerFactory.getLogger(CustomerResource.class);

    private final ModelMapper modelMapper;
    private final ICustomerService customerService;

    public CustomerResource(ModelMapper modelMapper, ICustomerService customerService) {
        this.modelMapper = modelMapper;
        this.customerService = customerService;
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<CustomerDto>> getAll(){
        logger.info("getAll init");
        List<Customer> customers = customerService.findAll();
        return ResponseEntity.of(Optional.of(GenericMapper.mapCollection(customers, CustomerDto.class, modelMapper)));
    }


}
