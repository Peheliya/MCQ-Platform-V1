package com.eduford.www.controller;

import com.eduford.www.entity.UserTest;
import com.eduford.www.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserTestController {

    @Autowired
    private UserTestService usertestService;

    @PostMapping("/usertest")
    public UserTest save(@RequestBody UserTest usertest){
        return usertestService.save(usertest);
    }

    @GetMapping("/usertest/{id}")
    public Optional<UserTest> getById(@PathVariable(value = "id") Long id){
        return usertestService.find(id);
    }

    @GetMapping("/usertest")
    public List<UserTest> getAll(){
        return usertestService.findAll();
    }

    @DeleteMapping("/usertest/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        usertestService.delete(id);
    }

    @DeleteMapping("/usertest")
    public void deleteAll(){
        usertestService.deleteAll();
    }

    @GetMapping("/usertest/count")
    public long count(){
        return usertestService.count();
    }
}