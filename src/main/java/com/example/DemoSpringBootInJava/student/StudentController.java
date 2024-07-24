package com.example.DemoSpringBootInJava.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public List<Student> list() {
        return studentService.getStudents();
    }

    @PostMapping("/register")
    public void register(@RequestBody Student newStudent) {
        studentService.addNewStudent(newStudent);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteStudentRequestModel requestModel) {
        studentService.deleteStudentById(requestModel.getId());
    }
}
