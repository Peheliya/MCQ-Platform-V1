package com.eduford.www.service;

import com.eduford.www.entity.Mcq;
import com.eduford.www.enums.DifficultyLevel;
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

    //void deleteAll();

    long count();

    Mcq update(Mcq mcq);

    List<Mcq> getMcqByModuleId(Long moduleId);

    List<Mcq> getMcqByDifficultyLevel(DifficultyLevel difficultyLevel);

    List<Mcq> getMcqByModuleIdAndDifficultyLevel(Long moduleId, DifficultyLevel difficultyLevel);
}