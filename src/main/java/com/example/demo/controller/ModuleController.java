package com.example.demo.controller;

import com.example.demo.dto.ModuleDto;
import com.example.demo.entity.Module;
import com.example.demo.entity.Subject;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.service.ModuleService;
import com.example.demo.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/module")
public class ModuleController {

    private final SubjectService subjectService;
    private final ModuleRepository moduleRepository;
    private final ModuleService moduleService;

    public ModuleController(SubjectService subjectService, ModuleRepository moduleRepository, ModuleService moduleService) {
        this.subjectService = subjectService;
        this.moduleRepository = moduleRepository;
        this.moduleService = moduleService;
    }

    @PostMapping("")
    public Module save(@RequestBody ModuleDto moduleDto){
        Module module = new Module();
        module.setName(moduleDto.getName());
        Optional<Subject> optionalSubject = subjectService.find(moduleDto.getSubjectId());
        optionalSubject.ifPresent(module::setSubjectId);
        return moduleService.save(module);
    }

    @GetMapping("/{id}")
    public Optional<Module> getById(@PathVariable(value = "id") Long id){
        return moduleService.find(id);
    }

    @GetMapping("")
    public List<Module> getAll(){
        return moduleService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        moduleService.delete(id);
    }

    //@DeleteMapping("")
    //public void deleteAll(){        moduleService.deleteAll();    }

    @GetMapping("/count")
    public long count(){
        return moduleService.count();
    }

    @PutMapping("")
    public Module update(@RequestBody ModuleDto moduleDto){
        Module existingModule = moduleRepository.findById(moduleDto.getId()).orElseThrow(() ->
        new ResourceNotFoundException("Module","ID",moduleDto.getId()));
        existingModule.setName(moduleDto.getName());
        Optional<Subject> optionalSubject = subjectService.find(moduleDto.getSubjectId());
        optionalSubject.ifPresent(existingModule::setSubjectId);
        return moduleService.update(existingModule);
    }

    @GetMapping("/subject/{id}")
    public List<Module> getModuleBySubjectId(@PathVariable(value = "id") Long id){
        return moduleService.getModuleBySubjectId(id);
    }

}