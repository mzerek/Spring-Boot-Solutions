package com.mzerek.springbootsolutions.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @OneToMany(mappedBy = "userid")
    @Fetch(FetchMode.JOIN)
    private List<Address> addresses;
}
