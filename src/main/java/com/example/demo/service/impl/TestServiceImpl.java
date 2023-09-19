package com.example.demo.service.impl;

import com.example.demo.entity.Test;
import com.example.demo.repository.TestRepository;
import com.example.demo.service.TestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {
    //This is a temp file by Peheliya. Replace this by Dinali's file
    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Optional<Test> find(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public List<Test> findAll(Sort sort){
        return testRepository.findAll(sort);
    }

    @Override
    public Page<Test> findAll(Pageable pageable){
        return testRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    testRepository.deleteById(id);
    }

    @Override
    public void delete(Test test) {
        testRepository.delete(test);
    }

    @Override
    public void deleteAll() {
        testRepository.deleteAll();
    }

    @Override
    public long count() {
        return testRepository.count();
    }

}