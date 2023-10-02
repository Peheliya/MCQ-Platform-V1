package com.eduford.www.service.impl;

import com.eduford.www.entity.Exam;
import com.eduford.www.enums.Type;
import com.eduford.www.repository.ExamRepository;
import com.eduford.www.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Optional<Exam> find(Long id) {
        return examRepository.findById(id);
    }

    @Override
    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    @Override
    public List<Exam> findAll(Sort sort){
        return examRepository.findAll(sort);
    }

    @Override
    public Page<Exam> findAll(Pageable pageable){
        return examRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    examRepository.deleteById(id);
    }

    @Override
    public void delete(Exam exam) {
        examRepository.delete(exam);
    }

    //@Override
    //public void deleteAll() {        examRepository.deleteAll();    }

    @Override
    public long count() {
        return examRepository.count();
    }

    @Override
    public Exam update(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public List<Exam> getExamByType(Type type) {
        return examRepository.getExamByType(type);
    }


}