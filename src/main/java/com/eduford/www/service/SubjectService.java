package com.eduford.www.service;

import com.eduford.www.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    Subject save(Subject subject);

    Optional<Subject> find(Long id);

    List<Subject> findAll();

    List<Subject> findAll(Sort sort);

    Page<Subject> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Subject subject);

    //void deleteAll();

    long count();

    Subject update(Subject subject);


}