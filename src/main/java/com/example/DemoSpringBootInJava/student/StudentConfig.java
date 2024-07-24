package com.example.DemoSpringBootInJava.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    // @Bean
    // CommandLineRunner commandLineRunner(StudentRepository repository) {
    // return args -> {
    // Student litaphat = new Student("Litaphat", "litaphat.ls@gmail.com",
    // LocalDate.of(1996, Month.OCTOBER, 16));
    //
    // repository.saveAll(List.of(litaphat));
    // };
    // }
}
