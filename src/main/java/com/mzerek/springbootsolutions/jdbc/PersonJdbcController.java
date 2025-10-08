package com.mzerek.springbootsolutions.jdbc;

import com.mzerek.springbootsolutions.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class PersonJdbcController {

    private final SQLInjectionExample sqlInjectionExample;


    //Sql injection if searchTerm= "' OR '1'='1' --"
    @GetMapping("/persons-jdbc/{searchTerm}")
    public List<Person> persons(@PathVariable("searchTerm") String searchTerm) throws SQLException {
        return sqlInjectionExample.getPersonJdbc(searchTerm);
    }
}
