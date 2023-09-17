package com.example.demo.repository;

import com.example.demo.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query(value = "SELECT * FROM answer where answer.mcq_id = :mcqId ;", nativeQuery = true)
    List<Answer> getAnswerByMcqId(@Param("mcqId") Long mcqId);
}