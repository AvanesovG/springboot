package com.example.springboot.service;

import com.example.springboot.repository.StudentRepository;
import com.example.springboot.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Student> studentOptional = repository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email taken");

        }
        repository.save(student);

    }

    public void deleteStudent(Long studentId) {
        boolean exist = repository.existsById(studentId);
        if (!exist){
            throw new IllegalStateException("student with id"+studentId+"does not exists");
        }
    repository.deleteById(studentId);

    }
}
