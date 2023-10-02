package com.eduford.www.controller;

import com.eduford.www.dto.UserDto;
import com.eduford.www.entity.User;
import com.eduford.www.enums.UserStatus;
import com.eduford.www.enums.UserType;
import com.eduford.www.exception.ResourceNotFoundException;
import com.eduford.www.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public User save(@RequestBody UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserType(UserType.valueOfUserType(userDto.getUserType()));
        user.setUserStatus(UserStatus.valueOfUserStatus(userDto.getUserStatus()));
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
    public User update(@RequestBody UserDto userDto){
        User existingUser = userService.find(userDto.getId()).orElseThrow(()->
                new ResourceNotFoundException("User","ID",userDto.getId()));//Custom exception
        existingUser.setName(userDto.getName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setPassword(userDto.getPassword());
        existingUser.setUserType(UserType.valueOfUserType(userDto.getUserType()));
        existingUser.setUserStatus(UserStatus.valueOfUserStatus(userDto.getUserStatus()));
        return userService.update(existingUser);
    }

    @GetMapping("/type/{type}")
    public List<User> getUserByUserType(@PathVariable(value = "type") int userType){
        return userService.getUserByUserType(UserType.valueOfUserType(userType));
    }
}