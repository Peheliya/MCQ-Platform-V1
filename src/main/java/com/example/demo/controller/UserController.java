package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable(value = "id") Long id){
        return userService.find(id);
    }

    @GetMapping("")
    public List<User> getAll(){
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        userService.delete(id);
    }

    //@DeleteMapping("/user")
    //public void deleteAll(){        userService.deleteAll();    }

    @GetMapping("/count")
    public long count(){
        return userService.count();
    }
}