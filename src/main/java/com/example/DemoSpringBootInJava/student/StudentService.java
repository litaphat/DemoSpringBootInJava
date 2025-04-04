package com.example.DemoSpringBootInJava.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service @Transactional @Slf4j
public class StudentService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> existingStudentByUsername = studentRepository.findStudentByEmail(username);
        if (!existingStudentByUsername.isPresent()) {
            throw new UsernameNotFoundException("User not found!!!");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        // todo remove hardcode
        authorities.add(new SimpleGrantedAuthority("admin"));
        return new org.springframework.security.core.userdetails.User(username, "", authorities);
    }

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StudentService(
        StudentRepository studentRepository
        ,PasswordEncoder passwordEncoder
        ) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student newStudent) {
        Optional<Student> existingStudentByEmail = studentRepository.findStudentByEmail(newStudent.getEmail());
        String passString = passwordEncoder.encode("");
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
