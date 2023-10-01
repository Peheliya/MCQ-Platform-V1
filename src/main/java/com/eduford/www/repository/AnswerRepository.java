package com.eduford.www.repository;

import com.eduford.www.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query(value = "SELECT * FROM answer where answer.mcq_id = :mcqId ;", nativeQuery = true)
    List<Answer> getAnswerByMcqId(@Param("mcqId") Long mcqId);
}