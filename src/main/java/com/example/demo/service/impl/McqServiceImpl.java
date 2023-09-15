package com.example.demo.service.impl;

import com.example.demo.entity.Mcq;
import com.example.demo.repository.McqRepository;
import com.example.demo.service.McqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class McqServiceImpl implements McqService {

    @Autowired
    private McqRepository mcqRepository;

    @Override
    public Mcq save(Mcq mcq) {
        return mcqRepository.save(mcq);
    }

    @Override
    public Optional<Mcq> find(Long id) {
        return mcqRepository.findById(id);
    }

    @Override
    public List<Mcq> findAll() {
        return mcqRepository.findAll();
    }

    @Override
    public List<Mcq> findAll(Sort sort){
        return mcqRepository.findAll(sort);
    }

    @Override
    public Page<Mcq> findAll(Pageable pageable){
        return mcqRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    mcqRepository.deleteById(id);
    }

    @Override
    public void delete(Mcq mcq) {
        mcqRepository.delete(mcq);
    }

    @Override
    public void deleteAll() {
        mcqRepository.deleteAll();
    }

    @Override
    public long count() {
        return mcqRepository.count();
    }

}