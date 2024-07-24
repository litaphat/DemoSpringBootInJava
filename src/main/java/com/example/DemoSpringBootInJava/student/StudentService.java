package com.example.DemoSpringBootInJava.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student newStudent) {
        Optional<Student> existingStudentByEmail = studentRepository.findStudentByEmail(newStudent.getEmail());
        if (existingStudentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        if (newStudent.getDob() == null) {
            throw new IllegalStateException("invalid date of birth");
        }
        studentRepository.save(newStudent);
    }

    public void deleteStudentById(Long studentId) {
        boolean existingStudent = studentRepository.existsById(studentId);
        if (!existingStudent) {
            throw new IllegalStateException("student id does not math");
        }
        studentRepository.deleteById(studentId);
    }
}
