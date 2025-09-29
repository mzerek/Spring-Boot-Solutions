package com.mzerek.springbootsolutions.redis.controller;

import com.mzerek.springbootsolutions.dto.PersonDto;
import com.mzerek.springbootsolutions.redis.model.Student;
import com.mzerek.springbootsolutions.redis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") String id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") String id) {
        return studentService.updateStudent(id);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") String id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/students-create")
    public void createStudents() {
        studentService.createStudents();
    }
}
