package com.example.studentmanagement;

import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins="http://localhost:3000")
public class StudentController {
  private final StudentRepository repo;
  public StudentController(StudentRepository repo){this.repo=repo;}

  @GetMapping public List<Student> getAll(){return repo.findAll();}
  @PostMapping public Map<String,String> add(@RequestBody Student s){
    repo.insert(s); return Map.of("message","Student created");
  }
  @PutMapping("/{id}") public Map<String,String> update(@PathVariable Long id,@RequestBody Student s){
    repo.update(id,s); return Map.of("message","Student updated");
  }
  @DeleteMapping("/{id}") public Map<String,String> delete(@PathVariable Long id){
    repo.delete(id); return Map.of("message","Student deleted");
  }
}
