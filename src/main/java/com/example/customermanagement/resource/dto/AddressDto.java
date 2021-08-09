package com.example.customermanagement.resource.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto implements Serializable {
    private String name;
    private String lineOne;
    private String lineTwo;
    private String city;
    private String region;
    private String zipCode;
    private String country;
    private Boolean status;
    @JsonBackReference
    private CustomerDto customer;
}
