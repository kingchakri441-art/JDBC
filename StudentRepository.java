package com.example.studentmanagement;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Student student) {
        String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";

        return jdbcTemplate.update(
            sql,
            student.getName(),
            student.getEmail(),
            student.getCourse()
        );
    }

    public List<Student> findAll() {
        String sql = "SELECT id, name, email, course FROM students ORDER BY id DESC";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new Student(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("course")
            )
        );
    }
}
