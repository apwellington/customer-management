package com.example.customermanagement.resource.dto;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;
@Data
public class PhoneDto extends AbstractPersistable<Long> {
    private String phoneNumber;
    private String phoneName;
    private Boolean status;
    private CustomerDto customer;
}
