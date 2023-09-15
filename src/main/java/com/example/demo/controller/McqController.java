package com.example.demo.controller;

import com.example.demo.entity.Mcq;
import com.example.demo.service.McqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/mcq")
public class McqController {

    @Autowired
    private McqService mcqService;

    @PostMapping("")
    public Mcq save(@RequestBody Mcq mcq){
        return mcqService.save(mcq);
    }

    @GetMapping("/{id}")
    public Optional<Mcq> getById(@PathVariable(value = "id") Long id){
        return mcqService.find(id);
    }

    @GetMapping("")
    public List<Mcq> getAll(){
        return mcqService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        mcqService.delete(id);
    }

    @DeleteMapping("")
    public void deleteAll(){
        mcqService.deleteAll();
    }

    @GetMapping("/count")
    public long count(){
        return mcqService.count();
    }
}