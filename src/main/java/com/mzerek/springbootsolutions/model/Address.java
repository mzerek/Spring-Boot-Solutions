package com.mzerek.springbootsolutions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue

    private Long id;

    private Long userid;

    private String street;
    private String zipcode;
    private String city;
}
