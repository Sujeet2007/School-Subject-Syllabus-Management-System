package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.repository.InstructorRepo;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepo instructorRepo;

    public Instructor create(Instructor mobj)
    {
        return instructorRepo.save(mobj);
    }

    public List<Instructor> read()
    {
        return instructorRepo.findAll();
    }

    public Optional<Instructor> getById(Long id)
    {
        Optional<Instructor> obj=instructorRepo.findById(id);
        return obj;
    }

    public Instructor update(Long id,Instructor obj)
    {
        Optional<Instructor> ob=instructorRepo.findById(id);
        obj.setInstructorId(id);
        instructorRepo.save(obj);
        return obj;
        
    }

    public Instructor delete(Long id)
    {
        Optional<Instructor> ob=instructorRepo.findById(id);
        instructorRepo.deleteById(id);
        return ob.get();
    }

    public List<Instructor> getBySpecialization(String specialization)
    {
        return instructorRepo.findBySpecialization(specialization);
    }

    public Page<Instructor> getByPage(Integer offset,Integer pagesize)
    {
        Pageable page=PageRequest.of(offset, pagesize);
        return instructorRepo.findAll(page);
    }

}
