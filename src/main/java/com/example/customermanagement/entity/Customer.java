package com.example.customermanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;

@Table(name = "customer")
@Entity
@Data
@NoArgsConstructor
public class Customer extends AbstractPersistable<Long> {
    private String name;
    private String lastName;
    private String email;
    private Boolean status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Phone> phones;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Address> addresses;
}
