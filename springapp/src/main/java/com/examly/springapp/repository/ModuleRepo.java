package com.examly.springapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Module;

@Repository
public interface ModuleRepo extends JpaRepository<Module,Long>{
    Optional<Module> findById(Long Id);
}
