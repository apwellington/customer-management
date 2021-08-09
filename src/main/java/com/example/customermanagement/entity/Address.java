package com.example.customermanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "lineOne cannot be null")
    private String lineOne;

    private String lineTwo;

    @NotNull(message = "city cannot be null")
    private String city;

    @NotNull(message = "region cannot be null")
    private String region;
    private String zipCode;

    @NotNull(message = "country cannot be null")
    private String country;

    @NotNull(message = "status cannot be null")
    private Boolean status;

    @ManyToOne
    private Customer customer;

}
