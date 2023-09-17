package com.example.demo.repository;

import com.example.demo.entity.Mcq;
import com.example.demo.entity.Module;
import com.example.demo.enums.DifficultyLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.converter.json.GsonBuilderUtils;

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