package com.sajed.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    @Column(length = 120)
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;
    private Boolean isDeleted;

}
