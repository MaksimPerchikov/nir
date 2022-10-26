package ru.nir.model;

import javax.persistence.GenerationType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ToString
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String secondName;

    private String dataCreateCustomer;

    public Customer(Long id, String firstName, String secondName, String dataCreateCustomer) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dataCreateCustomer = dataCreateCustomer;
    }
    public Customer(){}
}
