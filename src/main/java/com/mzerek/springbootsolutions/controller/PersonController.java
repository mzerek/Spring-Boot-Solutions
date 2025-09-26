package com.mzerek.springbootsolutions.controller;

import com.mzerek.springbootsolutions.dto.PersonDto;
import com.mzerek.springbootsolutions.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/persons")
    public List<PersonDto> persons() {
        return personService.getPersons();
    }

    @GetMapping("/persons/{id}")
    public PersonDto person(@PathVariable("id") Long id) {
        return personService.getPersonById(id);
    }

    @PutMapping("/persons")
    public void updatePerson(@RequestBody PersonDto personDto) {
        personService.updatePersonById(personDto);
    }

    @DeleteMapping("/persons")
    public void deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
    }

    @GetMapping("/clear-cache")
    public void clearCacheGetPersons() {
        personService.clearCacheGetPersons();
    }
}
