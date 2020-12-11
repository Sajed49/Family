package com.sajed.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "adult")
@Data
public class Adult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adultId;
    private String firstName;
    private String lastName;
    private Boolean isDeleted;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;

}
