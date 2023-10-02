package com.eduford.www.repository;

import com.eduford.www.entity.Exam;
import com.eduford.www.entity.Mcq;
import com.eduford.www.enums.DifficultyLevel;
import com.eduford.www.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    @Query(value = "SELECT * FROM Exam where exam.type = UPPER(:#{#type?.toString()}) ;", nativeQuery = true)
    List<Exam> getExamByType(@Param("type") Type type);
}