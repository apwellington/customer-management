package com.example.customermanagement.resource.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {
    private String name;
    private String lastName;
    private String email;
    private Boolean status;
    @JsonManagedReference
    private List<AddressDto> addresses;
}
