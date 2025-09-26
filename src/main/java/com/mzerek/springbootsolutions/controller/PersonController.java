package com.mzerek.springbootsolutions.controller;

import com.mzerek.springbootsolutions.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/persons")
    public void persons() {
        personService.getPersons();
    }

    @GetMapping("/persons/{id}")
    public void person(@PathVariable("id") Long id) {
        personService.getPersonById(id);
    }
}
