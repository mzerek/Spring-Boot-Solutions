package com.mzerek.springbootsolutions.jdbc;

import com.mzerek.springbootsolutions.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class SQLInjectionExample {

    private final DataSource pgDataSource;

    public List<Person> getPersonJdbc(String searchTerm) throws SQLException {
        String sql = "SELECT * FROM person WHERE username LIKE '%" + searchTerm + "%'";

        Connection connection = null;
        Statement statement = null;  // dangerous Statement interface
        ResultSet rs = null;


        connection = pgDataSource.getConnection();
        statement = connection.createStatement();
        rs = statement.executeQuery(sql); // note, we simply pass a raw string here

        List<Person> persons = new ArrayList<>();
        while (rs.next()) {
            Person person = new Person();
            person.setId(rs.getLong("ID"));
            person.setUsername(rs.getString("USERNAME"));
            persons.add(person);
        }

        return persons;
    }
}
