package com.example.DemoSpringBootInJava;

import org.springframework.web.bind.annotation.RestController;
import com.example.DemoSpringBootInJava.student.Student;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        if (name == null || name.isEmpty()) {
            name = "Litaphat";
        }
        String result = String.format("Hello, %s.", name);
        return result;
    }

    @GetMapping("/hellostudent")
    public List<Student> hellostudent() {
        return List.of(new Student(1L, "Litaphat", "litaphat.ls@gmail.com", LocalDate.of(1996, Month.OCTOBER, 16)));
    }
}
