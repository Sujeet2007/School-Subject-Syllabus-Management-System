package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.examly.springapp.model.Instructor;
import com.examly.springapp.service.InstructorService;

@RestController
@RequestMapping("/api")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;
    
    @PostMapping("/instructors")
    public ResponseEntity<Instructor> create(@RequestBody Instructor mobj)
    {
        try{
            Instructor saved=instructorService.create(mobj);
            return new ResponseEntity<>(saved,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> getAll()
    {
        List list=instructorService.read();
        if(list.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
    

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> getData(@PathVariable long id)
    {
        Optional<Instructor> obj=instructorService.getById(id);
        if(obj.isPresent())
        return new ResponseEntity<>(obj.get(),HttpStatus.OK); 
        else
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
    }

    @PutMapping("/instructors/{id}")
    public ResponseEntity<Instructor> update(@PathVariable long id,@RequestBody Instructor mobj)
    {
        Instructor ob=instructorService.update(id, mobj);
        return new ResponseEntity<>(ob,HttpStatus.OK);
    }

    @DeleteMapping("/instructors/{id}")
    public ResponseEntity delete(@PathVariable long id)
    {
        instructorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/instructors/specialization/{specialization}")
    public ResponseEntity<?> getBySpecialization(@PathVariable String specialization)
    {
        List<Instructor> list=instructorService.getBySpecialization(specialization);
        if(list.isEmpty())
        return new ResponseEntity<>("No instructors found with specialization: "+specialization,HttpStatus.NOT_FOUND);
        else
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/instructors/page/{page}/{size}")
    public ResponseEntity<Page<Instructor>> get(@PathVariable int page,@PathVariable int size)
    {
        Page<Instructor> pag=instructorService.getByPage(page, size);
        return new ResponseEntity<>(pag,HttpStatus.OK);
    }

}
