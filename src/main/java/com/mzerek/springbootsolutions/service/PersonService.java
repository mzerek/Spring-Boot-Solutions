package com.mzerek.springbootsolutions.service;


import com.mzerek.springbootsolutions.dto.PersonDto;
import com.mzerek.springbootsolutions.dto.PersonMapper;
import com.mzerek.springbootsolutions.model.Person;
import com.mzerek.springbootsolutions.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    //https://www.baeldung.com/spring-boot-ehcache
    @Cacheable(cacheNames = "GetPersons")
    public List<PersonDto> getPersons() {
        List<Person> persons = personRepository.findAll();
        return persons.stream()
                .map(personMapper::personToPersonDto)
                .toList();
    }

    @Cacheable(cacheNames = "GetPersonById", key = "#id")
    public PersonDto getPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow();
        return personMapper.personToPersonDto(person);
    }

    @CachePut(cacheNames = "GetPersonById", key = "#result.id")
    public PersonDto updatePersonById(PersonDto personDto) {
        Person person = personRepository.findById(personDto.getId()).orElseThrow();
        person.setUsername(personDto.getUsername());
        personRepository.save(person);
        return personMapper.personToPersonDto(person);
    }

    @CacheEvict(cacheNames = "GetPersonById")
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @CacheEvict(cacheNames = "GetPersons")
    public void clearCacheGetPersons() {

    }
}
