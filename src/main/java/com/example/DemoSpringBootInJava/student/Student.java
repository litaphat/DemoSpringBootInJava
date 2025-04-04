package com.example.DemoSpringBootInJava.student;

import java.time.LocalDate;
import java.time.Period;
import jakarta.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private long id;
    private String name;
    private String email;
    private LocalDate dateofbirth;
    private String active;

    @Transient
    private Integer age;

    public Student() {
    }

    public Student(long id, String name, String email, LocalDate dateofbirth, String active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateofbirth = dateofbirth;
        this.active = active;
    }

    public Student(String name, String email, LocalDate dateofbirth, String active) {
        this.name = name;
        this.email = email;
        this.dateofbirth = dateofbirth;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dateofbirth;
    }

    public Integer getAge() {
        return Period.between(this.dateofbirth, LocalDate.now()).getYears();
    }

    public String getActive() {
        return active;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dateofbirth + ", age=" + age
                + "]";
    }
}
