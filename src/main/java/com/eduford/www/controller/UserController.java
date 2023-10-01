package com.eduford.www.controller;

import com.eduford.www.entity.User;
import com.eduford.www.enums.UserType;
import com.eduford.www.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("")
    public ResponseEntity<User> update(@RequestBody User user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    public List<User> getUserByUserType(@PathVariable(value = "type") int userType){
        return userService.getUserByUserType(UserType.valueOfUserType(userType));
    }
}