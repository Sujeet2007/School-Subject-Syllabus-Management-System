package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Course;
import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    public Course create(Course mobj)
    {
        return courseRepo.save(mobj);
    } 

    public List<Course> read()
    {
        return courseRepo.findAll();
    } 

    public Optional<Course> getById(Long id)
    {
        Optional<Course> obj=courseRepo.findById(id);
        return obj;
    }

    public Course update(Long id,Course obj)
    {
        Optional<Course> ob=courseRepo.findById(id);
        obj.setCourseId(id);
        courseRepo.save(obj);
        return obj;
        
    }

    public Course delete(Long id)
    {
        Optional<Course> ob=courseRepo.findById(id);
        courseRepo.deleteById(id);
        return ob.get();
    }

    public List<Course> getByInstructorId(Long Id)
    {
        return courseRepo.findByInstructor_InstructorId(Id);
    }

    public List<Course> getByLevel(String level)
    {
        return courseRepo.findByLevel(level);
    }
}

