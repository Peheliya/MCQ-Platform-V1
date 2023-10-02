package com.eduford.www.controller;

import com.eduford.www.entity.Subject;
import com.eduford.www.exception.ResourceNotFoundException;
import com.eduford.www.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("")
    public Subject save(@RequestBody Subject subject){
        return subjectService.save(subject);
    }

    @GetMapping("/{id}")
    public Optional<Subject> getById(@PathVariable(value = "id") Long id){
        return subjectService.find(id);
    }

    @GetMapping("")
    public List<Subject> getAll(){
        return subjectService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        subjectService.delete(id);
    }

    //@DeleteMapping("")
    //public void deleteAll(){subjectService.deleteAll();}

    @GetMapping("/count")
    public long count(){
        return subjectService.count();
    }

    @PutMapping("")
    public Subject update(@RequestBody Subject subject){
        Subject optionalSubject = subjectService.find(subject.getId()).orElseThrow(()->
                new ResourceNotFoundException("Subject","ID",subject.getId()));
        optionalSubject.setName(subject.getName());
        return subjectService.update(optionalSubject);
    }
}