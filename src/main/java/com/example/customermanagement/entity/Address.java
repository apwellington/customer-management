package com.example.customermanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Table(name = "address")
@Entity
@Data
@NoArgsConstructor
public class Address extends AbstractPersistable<Long> {
    private String name;
    private String lineOne;
    private String lineTwo;
    private String city;
    private String region;
    private String zipCode;
    private String country;
    private Boolean status;

    @ManyToOne
    private Customer customer;

}
