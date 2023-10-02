package com.eduford.www.service;

import com.eduford.www.entity.Exam;
import com.eduford.www.enums.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ExamService {

    Exam save(Exam exam);

    Optional<Exam> find(Long id);

    List<Exam> findAll();

    List<Exam> findAll(Sort sort);

    Page<Exam> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Exam exam);

    //void deleteAll();

    long count();

    Exam update(Exam exam);

    List<Exam> getExamByType(Type type);
}