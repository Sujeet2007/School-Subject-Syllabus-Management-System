package com.examly.springapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Instructor;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor,Long>{
    Optional<Instructor> findById(Long Id);
    List<Instructor> findBySpecialization(String specialization);
}
