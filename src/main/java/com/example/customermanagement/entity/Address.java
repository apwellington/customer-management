package com.example.customermanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
