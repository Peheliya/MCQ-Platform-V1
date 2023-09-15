package com.example.demo.repository;

import com.example.demo.entity.Mcq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface McqRepository extends JpaRepository<Mcq, Long> {
}