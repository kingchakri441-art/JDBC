package com.example.studentmanagement;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Map<String, String> addStudent(@RequestBody Student student) {

        repository.save(student);

        return Map.of("message", "Student saved successfully");
    }

    @GetMapping
    public List<Student> getStudents() {

        return repository.findAll();
    }
}
