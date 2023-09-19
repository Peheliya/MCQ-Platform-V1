package com.example.demo.service;

import com.example.demo.entity.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface AnswerService {

    Answer save(Answer answer);

    Optional<Answer> find(Long id);

    List<Answer> findAll();

    List<Answer> findAll(Sort sort);

    Page<Answer> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Answer answer);

    //void deleteAll();

    long count();

    Answer update(Answer answer);

    List<Answer> getAnswerByMcqId(Long mcqId);
}