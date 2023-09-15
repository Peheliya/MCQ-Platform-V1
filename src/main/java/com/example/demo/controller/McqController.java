package com.example.demo.controller;

import com.example.demo.dto.McqDto;
import com.example.demo.entity.Mcq;
import com.example.demo.entity.Module;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.McqRepository;
import com.example.demo.service.McqService;
import com.example.demo.service.ModuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/mcq")
public class McqController {

    private final McqService mcqService;
    private final ModuleService moduleService;

    private final McqRepository mcqRepository;

    public McqController(McqService mcqService, ModuleService moduleService, McqRepository mcqRepository) {
        this.mcqService = mcqService;
        this.moduleService = moduleService;
        this.mcqRepository = mcqRepository;
    }

    @PostMapping("")
    public Mcq save(@RequestBody McqDto mcqDto){
        Mcq mcq = new Mcq();
        Optional<Module> optionalModule = moduleService.find(mcqDto.getModuleId());
        if(optionalModule.isPresent()){
            mcq.setModule(optionalModule.get());
        }
        mcq.setQuestion(mcqDto.getQuestion());
        mcq.setExplanation(mcqDto.getExplanation());
        mcq.setType(mcqDto.getType());
        mcq.setDifficultyLevel(mcqDto.getDifficultyLevel());

        return mcqService.save(mcq);
    }

    @GetMapping("/{id}")
    public Optional<Mcq> getById(@PathVariable(value = "id") Long id){
        return mcqService.find(id);
    }

    @GetMapping("")
    public List<Mcq> getAll(){
        return mcqService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        mcqService.delete(id);
    }

    //@DeleteMapping("")
    //public void deleteAll(){        mcqService.deleteAll();    }

    @GetMapping("/count")
    public long count(){
        return mcqService.count();
    }

    @PutMapping
    public Mcq update(@RequestBody McqDto mcqDto){
        Mcq exixtingMcq = mcqRepository.findById(mcqDto.getId()).orElseThrow(() ->
                new ResourceNotFoundException("MCQ","ID",mcqDto.getId()));
        Optional<Module> optionalModule = moduleService.find(mcqDto.getModuleId());
        if(optionalModule.isPresent()){
            exixtingMcq.setModule(optionalModule.get());
        }
        exixtingMcq.setQuestion(mcqDto.getQuestion());
        exixtingMcq.setExplanation(mcqDto.getExplanation());
        exixtingMcq.setType(mcqDto.getType());
        exixtingMcq.setDifficultyLevel(mcqDto.getDifficultyLevel());

        return mcqService.update(exixtingMcq);
    }
}