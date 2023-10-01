package com.eduford.www.service.impl;

import com.eduford.www.entity.User;
import com.eduford.www.enums.UserType;
import com.eduford.www.repository.UserRepository;
import com.eduford.www.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> find(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAll(Sort sort){
        return userRepository.findAll(sort);
    }

    @Override
    public Page<User> findAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    userRepository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    //@Override
    //public void deleteAll() {        userRepository.deleteAll();    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUserByUserType(UserType userType) {
        return userRepository.getUserByUserType(userType);
    }

}