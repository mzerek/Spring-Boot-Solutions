package com.mzerek.springbootsolutions.redis.service;

import com.mzerek.springbootsolutions.redis.model.Student;
import com.mzerek.springbootsolutions.redis.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public void createStudents() {
        Student student = new Student("Pln2015002", "Franek Kimono", Student.Gender.MALE, 1);
        studentRepository.save(student);
        Student engStudent = new Student(
                "Eng2015001", "John Doe", Student.Gender.MALE, 1);
        Student medStudent = new Student(
                "Med2015001", "Gareth Houston", Student.Gender.MALE, 2);
        studentRepository.save(engStudent);
        studentRepository.save(medStudent);
    }

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Student getStudentById(String studentId){
        return studentRepository.findById(studentId).get();
    }

    public Student updateStudent(String studentId){
        Student retrievedStudent = studentRepository.findById(studentId).get();
        retrievedStudent.setName("Richard Watson");
        return studentRepository.save(retrievedStudent);
    }

    public void deleteStudent(String studentId) {
        studentRepository.deleteById(studentId);
    }
}
