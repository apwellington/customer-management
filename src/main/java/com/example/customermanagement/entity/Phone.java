package com.example.customermanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "phone")
@Entity
@Data
@NoArgsConstructor
public class Phone extends AbstractPersistable<Long> {
    private String phoneNumber;
    private String phoneName;
    private Boolean status;

    @ManyToOne
    private Customer customer;
}
