package com.eduford.www.service;

import com.eduford.www.entity.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface TestService {

    //This is a temp file by Peheliya. Replace this by Dinali's file
    Test save(Test test);

    Optional<Test> find(Long id);

    List<Test> findAll();

    List<Test> findAll(Sort sort);

    Page<Test> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Test test);

    void deleteAll();

    long count();

}