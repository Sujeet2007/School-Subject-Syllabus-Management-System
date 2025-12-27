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

import com.examly.springapp.model.Student;
import com.examly.springapp.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private  StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Student> create(@RequestBody Student mobj)
    {
        try{
            Student saved=studentService.create(mobj);
            return new ResponseEntity<>(saved,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAll()
    {
        List<Student> list=studentService.read();
        if(list.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
    

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getData(@PathVariable long id)
    {
        Optional<Student> obj=studentService.getById(id);
        if(obj.isPresent())
        return new ResponseEntity<>(obj.get(),HttpStatus.OK); 
        else
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> update(@PathVariable long id,@RequestBody Student mobj)
    {
        Student ob=studentService.update(id, mobj);
        return new ResponseEntity<>(ob,HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable long id)
    {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/students/email/{email}")
    public ResponseEntity<Student> getByEmail(@PathVariable String email)
    {
        Student stud=studentService.getByEmail(email);
        return new ResponseEntity<>(stud,HttpStatus.OK);
    }
}
