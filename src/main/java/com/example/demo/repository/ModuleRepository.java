package com.example.demo.repository;

import com.example.demo.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}