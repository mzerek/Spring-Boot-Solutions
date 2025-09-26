package com.mzerek.springbootsolutions.service;


import com.mzerek.springbootsolutions.dto.PersonDto;
import com.mzerek.springbootsolutions.dto.PersonMapper;
import com.mzerek.springbootsolutions.model.Address;
import com.mzerek.springbootsolutions.model.Person;
import com.mzerek.springbootsolutions.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Cacheable(cacheNames = "GetPersons")
    public List<PersonDto> getPersons() {
        List<Person> persons = personRepository.findAll();
        return persons.stream()
                .map(personMapper::personToPersonDto)
                .toList();
    }

    @Cacheable(cacheNames = "GetPersonById", key = "#id")
    public void getPersonById(Long id) {
        Person person = personRepository.findById(id).get();
        System.out.println(person.getAddresses());
    }
}
