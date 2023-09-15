package com.example.demo.service.impl;

import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.service.SubjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Optional<Subject> find(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Subject> findAll(Sort sort){
        return subjectRepository.findAll(sort);
    }

    @Override
    public Page<Subject> findAll(Pageable pageable){
        return subjectRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    subjectRepository.deleteById(id);
    }

    @Override
    public void delete(Subject subject) {
        subjectRepository.delete(subject);
    }

    //@Override
    //public void deleteAll() {subjectRepository.deleteAll();}

    @Override
    public long count() {
        return subjectRepository.count();
    }

    @Override
    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }

}