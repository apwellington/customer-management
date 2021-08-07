package com.example.customermanagement.resource.dto;

import lombok.Data;
import java.util.Set;

@Data
public class CustomerDto {
    private String name;
    private String lastName;
    private String email;
    private Boolean status;
    private Set<PhoneDto> phones;
    private Set<AddressDto> addresses;
}
