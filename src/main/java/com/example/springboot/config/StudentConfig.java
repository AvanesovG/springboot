package com.example.springboot.config;

import com.example.springboot.repository.StudentRepository;
import com.example.springboot.student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student mariam = new Student(
                     "Mariam",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    "marian@gmail.com"


            );
            Student alex = new Student(
                     "Alex",
                    LocalDate.of(2004, Month.JANUARY, 5),
                    "Alex@gmail.com"



            );
            studentRepository.saveAll(List.of(mariam,alex));

        };
    }
}
