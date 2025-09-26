package com.mzerek.springbootsolutions.service;


import com.mzerek.springbootsolutions.model.Address;
import com.mzerek.springbootsolutions.model.Person;
import com.mzerek.springbootsolutions.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public void getPersons() {
        // no N+1 but without pagination
        List<Person> persons = personRepository.findAll();
        persons.forEach(person -> {
            if(person != null) {
                List<Address> addresses = person.getAddresses();
                if(!addresses.isEmpty()) {
                    System.out.println(addresses.getFirst().getCity());
                }
            }
            else {
                System.out.println("Person is null");
            }
        });
    }

    public void getPersonById(Long id) {
        Person person = personRepository.findById(id).get();
        System.out.println(person.getAddresses());
    }
}
