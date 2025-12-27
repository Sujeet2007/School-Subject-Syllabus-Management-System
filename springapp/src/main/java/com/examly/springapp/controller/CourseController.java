package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Course;
import com.examly.springapp.model.Instructor;
import com.examly.springapp.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {
   @Autowired
   private CourseService courseService;
   
   @PostMapping("/courses")
   public ResponseEntity<Course> create(@RequestBody Course mobj)
   {
    Course saved=courseService.create(mobj);
    return new ResponseEntity<>(saved,HttpStatus.CREATED);
   }

   @GetMapping("/courses")
   public ResponseEntity<List<Course>> getAll()
   {
     List<Course> list =courseService.read();
     return new ResponseEntity<>(list,HttpStatus.OK);
   }


    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getData(@PathVariable long id)
    {
        Optional<Course> obj=courseService.getById(id);
        return new ResponseEntity<>(obj.get(),HttpStatus.OK);   
    }
   
    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> update(@PathVariable long id,@RequestBody Course mobj)
    {
        Course ob=courseService.update(id, mobj);
        return new ResponseEntity<>(ob,HttpStatus.OK);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity delete(@PathVariable long id)
    {
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/courses/instructor/{instructorId}")
    public ResponseEntity<List<Course>> getByInstructorId(@PathVariable long instructorId)
    {
        try{
            List<Course> list=courseService.getByInstructorId(instructorId);
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(null);
        }
    }

    @GetMapping("/courses/level/{level}")
    public ResponseEntity<?> getByLevel(@PathVariable String level)
    {
        
        List<Course> list=courseService.getByLevel(level);
        if(list.isEmpty())
        return new ResponseEntity<>("No courses found at level: "+level,HttpStatus.NO_CONTENT);
        else
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
