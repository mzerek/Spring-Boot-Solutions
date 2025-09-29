package com.mzerek.springbootsolutions.redis.repository;

import com.mzerek.springbootsolutions.redis.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

}
