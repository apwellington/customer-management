package com.example.customermanagement.entity;

import com.example.customermanagement.util.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "customer")
@Entity
@Data
@NoArgsConstructor
public class Customer extends AbstractPersistable<Long> {

    private String name;
    private String lastName;
    private String email;
    private Status status;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Phone> phones;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Address> addresses;
}
