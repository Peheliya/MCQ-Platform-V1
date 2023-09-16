package com.example.demo.service;

import com.example.demo.entity.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ModuleService {

    Module save(Module module);

    Optional<Module> find(Long id);

    List<Module> findAll();

    List<Module> findAll(Sort sort);

    Page<Module> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Module module);

    //void deleteAll();

    long count();

    Module update(Module module);

    List<Module> getModuleBySubjectId(Long subjectId);
}