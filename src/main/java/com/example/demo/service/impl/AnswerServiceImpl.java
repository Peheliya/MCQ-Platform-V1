package com.example.demo.service.impl;

import com.example.demo.entity.Answer;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.service.AnswerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Optional<Answer> find(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public List<Answer> findAll(Sort sort){
        return answerRepository.findAll(sort);
    }

    @Override
    public Page<Answer> findAll(Pageable pageable){
        return answerRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    answerRepository.deleteById(id);
    }

    @Override
    public void delete(Answer answer) {
        answerRepository.delete(answer);
    }

    //@Override
    //public void deleteAll() {        answerRepository.deleteAll();    }

    @Override
    public long count() {
        return answerRepository.count();
    }

    @Override
    public Answer update(Answer answer) {
        return answerRepository.save(answer);
    }

}