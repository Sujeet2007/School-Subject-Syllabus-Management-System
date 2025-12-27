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


import com.examly.springapp.service.ModuleService;
import com.examly.springapp.model.Module;

@RestController
@RequestMapping("/api")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @PostMapping("/modules")
    public ResponseEntity<Module> create(@RequestBody Module mobj)
    {
        try{
            Module saved=moduleService.create(mobj);
            return new ResponseEntity<>(saved,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/modules")
    public ResponseEntity<List<Module>> getAll()
    {
        List list=moduleService.read();
        if(list.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
    

    @GetMapping("/modules/{id}")
    public ResponseEntity<Module> getData(@PathVariable long id)
    {
        Optional<Module> obj=moduleService.getById(id);
        if(obj.isPresent())
        return new ResponseEntity<>(obj.get(),HttpStatus.OK); 
        else
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
    }

    @PutMapping("/modules/{id}")
    public ResponseEntity<Module> update(@PathVariable long id,@RequestBody Module mobj)
    {
        Module ob=moduleService.update(id, mobj);
        return new ResponseEntity<>(ob,HttpStatus.OK);
    }

    @DeleteMapping("/modules/{id}")
    public ResponseEntity delete(@PathVariable long id)
    {
        moduleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
