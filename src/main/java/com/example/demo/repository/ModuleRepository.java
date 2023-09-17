package com.example.demo.repository;

import com.example.demo.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {
    @Query(value = "SELECT * FROM module where module.subject_Id = :subjectId ;", nativeQuery = true)//if many use "subject ."
    List<Module> getModuleBySubjectId(@Param("subjectId") Long subjectId);
}