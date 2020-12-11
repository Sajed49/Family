package com.sajed.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "child")
@Data
public class Child {

    @ManyToOne
    @JoinColumn(name = "adultId")
    private Adult adult;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer childId;
    private String firstName;
    private String lastName;
    private Boolean isDeleted;
}
