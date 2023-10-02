package com.eduford.www.service.impl;

import com.eduford.www.entity.UserTest;
import com.eduford.www.repository.UserTestRepository;
import com.eduford.www.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class UserTestServiceImpl implements UserTestService {

    @Autowired
    private UserTestRepository usertestRepository;

    @Override
    public UserTest save(UserTest usertest) {
        return usertestRepository.save(usertest);
    }

    @Override
    public Optional<UserTest> find(Long id) {
        return usertestRepository.findById(id);
    }

    @Override
    public List<UserTest> findAll() {
        return usertestRepository.findAll();
    }

    @Override
    public List<UserTest> findAll(Sort sort){
        return usertestRepository.findAll(sort);
    }

    @Override
    public Page<UserTest> findAll(Pageable pageable){
        return usertestRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    usertestRepository.deleteById(id);
    }

    @Override
    public void delete(UserTest usertest) {
        usertestRepository.delete(usertest);
    }

    @Override
    public void deleteAll() {
        usertestRepository.deleteAll();
    }

    @Override
    public long count() {
        return usertestRepository.count();
    }

    @Override
    public UserTest update(UserTest usertest) {
        return null;
    }

}