package com.example.demo.service;

import com.example.demo.entity.Mcq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface McqService {

    Mcq save(Mcq mcq);

    Optional<Mcq> find(Long id);

    List<Mcq> findAll();

    List<Mcq> findAll(Sort sort);

    Page<Mcq> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Mcq mcq);

    void deleteAll();

    long count();

}