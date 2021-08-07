package com.example.customermanagement.resource.dto;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;
@Data
public class AddressDto extends AbstractPersistable<Long> {
    private String name;
    private String lineOne;
    private String lineTwo;
    private String city;
    private String region;
    private String zipCode;
    private String country;
    private Boolean status;
    private CustomerDto customer;
}
