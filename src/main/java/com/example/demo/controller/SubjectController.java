package com.example.demo.controller;

import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;
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
    public ResponseEntity<Subject> update(@RequestBody Subject subject){
        return new ResponseEntity<>(subjectService.update(subject), HttpStatus.OK);
    }
}