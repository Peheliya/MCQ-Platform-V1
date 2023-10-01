package com.eduford.www.repository;

import com.eduford.www.entity.Mcq;
import com.eduford.www.enums.DifficultyLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface McqRepository extends JpaRepository<Mcq, Long> {
    @Query(value = "SELECT * FROM mcq where mcq.module_id = :moduleId ;", nativeQuery = true)
    List<Mcq> getMcqByModuleId(@Param("moduleId") Long moduleId);

    //@Query(value = "SELECT * FROM mcq where mcq.difficulty_level = :difficultyLevel ;", nativeQuery = true)
    @Query(value = "SELECT * FROM mcq where mcq.difficulty_level = UPPER(:#{#difficultyLevel?.toString()}) ;", nativeQuery = true)
    List<Mcq> getMcqByDifficultyLevel(@Param("difficultyLevel") DifficultyLevel difficultyLevel);

    @Query(value = "SELECT * FROM mcq where mcq.module_id = :moduleId and mcq.difficulty_level = UPPER(:#{#difficultyLevel?.toString()});", nativeQuery = true)
    List<Mcq> getMcqByModuleIdAndDifficultyLevel(@Param("moduleId") Long moduleId,@Param("difficultyLevel") DifficultyLevel difficultyLevel);
}