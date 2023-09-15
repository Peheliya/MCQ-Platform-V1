package com.example.demo.service.impl;

import com.example.demo.entity.Module;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.service.ModuleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Module save(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public Optional<Module> find(Long id) {
        return moduleRepository.findById(id);
    }

    @Override
    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    @Override
    public List<Module> findAll(Sort sort){
        return moduleRepository.findAll(sort);
    }

    @Override
    public Page<Module> findAll(Pageable pageable){
        return moduleRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    moduleRepository.deleteById(id);
    }

    @Override
    public void delete(Module module) {
        moduleRepository.delete(module);
    }

    //@Override
    //public void deleteAll() {moduleRepository.deleteAll();}

    @Override
    public long count() {
        return moduleRepository.count();
    }

    @Override
    public Module update(Module module) {
        return moduleRepository.save(module);
    }

}