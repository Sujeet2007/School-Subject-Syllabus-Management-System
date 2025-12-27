package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.repository.ModuleRepo;
import com.examly.springapp.model.Instructor;
import com.examly.springapp.model.Module;

@Service
public class ModuleService {
    @Autowired
    private ModuleRepo moduleRepo;

    public Module create(Module mobj)
    {
        return moduleRepo.save(mobj);
    }

    public List<Module> read()
    {
        return moduleRepo.findAll();
    }

    public Optional<Module> getById(Long id)
    {
        Optional<Module> obj=moduleRepo.findById(id);
        return obj;
    }

    public Module update(Long id,Module obj)
    {
        Optional<Module> ob=moduleRepo.findById(id);
        obj.setModuleId(id);
        moduleRepo.save(obj);
        return obj;
        
    }

    public Module delete(Long id)
    {
        Optional<Module> ob=moduleRepo.findById(id);
        moduleRepo.deleteById(id);
        return ob.get();
    }
}
