package com.example.studentmanagement;

import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
  private final JdbcTemplate jdbc;
  public StudentRepository(JdbcTemplate jdbc){this.jdbc=jdbc;}

  public List<Student> findAll(){
    return jdbc.query("SELECT id,name,email,course FROM students",
      (rs,n)->new Student(rs.getLong("id"),rs.getString("name"),rs.getString("email"),rs.getString("course")));
  }
  public int insert(Student s){
    return jdbc.update("INSERT INTO students(name,email,course) VALUES(?,?,?)",s.getName(),s.getEmail(),s.getCourse());
  }
  public int update(Long id, Student s){
    return jdbc.update("UPDATE students SET name=?,email=?,course=? WHERE id=?",s.getName(),s.getEmail(),s.getCourse(),id);
  }
  public int delete(Long id){return jdbc.update("DELETE FROM students WHERE id=?",id);}
}
