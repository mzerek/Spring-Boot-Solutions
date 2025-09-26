package com.mzerek.springbootsolutions.repository;

import com.mzerek.springbootsolutions.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @EntityGraph(attributePaths = {"addresses"})
    List<Person> findAll();

    @EntityGraph(attributePaths = {"addresses"})
    Page<Person> findAllBy(Pageable pageable);
}
