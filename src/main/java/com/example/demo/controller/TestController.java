package com.example.demo.controller;

import com.example.demo.entity.Test;
import com.example.demo.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class TestController {
    //This is a temp file by Peheliya. Replace this by Dinali's file
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/test")
    public Test save(@RequestBody Test test){
        return testService.save(test);
    }

    @GetMapping("/test/{id}")
    public Optional<Test> getById(@PathVariable(value = "id") Long id){
        return testService.find(id);
    }

    @GetMapping("/test")
    public List<Test> getAll(){
        return testService.findAll();
    }

    @DeleteMapping("/test/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        testService.delete(id);
    }

    @DeleteMapping("/test")
    public void deleteAll(){
        testService.deleteAll();
    }

    @GetMapping("/test/count")
    public long count(){
        return testService.count();
    }
}