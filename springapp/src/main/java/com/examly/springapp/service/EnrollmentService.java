package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Course;
import com.examly.springapp.model.Enrollment;
import com.examly.springapp.repository.EnrollmentRepo;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepo enrollmentRepo;

    public Enrollment create(Enrollment mobj)
    {
        return enrollmentRepo.save(mobj);
    } 

    public List<Enrollment> read()
    {
        return enrollmentRepo.findAll();
    }

    public Optional<Enrollment> getById(Long id)
    {
        Optional<Enrollment> obj=enrollmentRepo.findById(id);
        return obj;
    }

    public Enrollment update(Long id,Enrollment obj)
    {
        Optional<Enrollment> ob=enrollmentRepo.findById(id);
        obj.setEnrollmentId(id);
        enrollmentRepo.save(obj);
        return obj;
        
    }

    public Enrollment delete(Long id)
    {
        Optional<Enrollment> ob=enrollmentRepo.findById(id);
        enrollmentRepo.deleteById(id);
        return ob.get();
    }
}
