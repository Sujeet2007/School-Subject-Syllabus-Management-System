package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Student;
import com.examly.springapp.repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    
    public Student create(Student mobj)
    {
        return studentRepo.save(mobj);
    }

    public List<Student> read()
    {
        return studentRepo.findAll();
    }

    public Optional<Student> getById(Long id)
    {
        Optional<Student> obj=studentRepo.findById(id);
        return obj;
    }

    public Student update(Long id,Student obj)
    {
        Optional<Student> ob=studentRepo.findById(id);
        obj.setStudentId(id);
        studentRepo.save(obj);
        return obj;
        
    }

    public Student delete(Long id)
    {
        Optional<Student> ob=studentRepo.findById(id);
        studentRepo.deleteById(id);
        return ob.get();
    }

    public Student getByEmail(String email)
    {
        return studentRepo.findByEmail(email);
    }
}
