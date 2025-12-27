package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Enrollment;
import com.examly.springapp.service.EnrollmentService;

@RestController
@RequestMapping("/api")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enrollments")
   public ResponseEntity<Enrollment> create(@RequestBody Enrollment mobj)
   {
    Enrollment saved=enrollmentService.create(mobj);
    return new ResponseEntity<>(saved,HttpStatus.CREATED);
   }

   @GetMapping("/enrollments")
   public ResponseEntity<List<Enrollment>> getAll()
   {
     List<Enrollment> list =enrollmentService.read();
     return new ResponseEntity<>(list,HttpStatus.OK);
   }


    @GetMapping("/enrollments/{id}")
    public ResponseEntity<Enrollment> getData(@PathVariable long id)
    {
        Optional<Enrollment> obj=enrollmentService.getById(id);
        return new ResponseEntity<>(obj.get(),HttpStatus.OK);   
    }
   
    @PutMapping("/enrollments/{id}")
    public ResponseEntity<Enrollment> update(@PathVariable long id,@RequestBody Enrollment mobj)
    {
        Enrollment ob=enrollmentService.update(id, mobj);
        return new ResponseEntity<>(ob,HttpStatus.OK);
    }

    @DeleteMapping("/enrollments/{id}")
    public ResponseEntity delete(@PathVariable long id)
    {
        enrollmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
