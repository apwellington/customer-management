package com.example.customermanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name cannot be null")
    private String name;
    private String lastName;
    @NotNull(message = "email cannot be null")
    private String email;
    @NotNull(message = "status cannot be null")
    private Boolean status;
    @NotNull(message = "status cannot be null")
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;
}
