package com.examly.springapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long>{
    Optional<Student> findById(Long Id);
    Student findByEmail(String email);
}
