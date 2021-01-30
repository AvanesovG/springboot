package com.example.springboot.service;

import com.example.springboot.repository.StudentRepository;
import com.example.springboot.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }


    public List<Student> getStudent() {
        return repository.findAll();


    }

    public void addNewStudent(Student student) {
        System.out.println(student);
    }
}
