package com.eduford.www.controller;

import com.eduford.www.dto.McqDto;
import com.eduford.www.entity.Mcq;
import com.eduford.www.entity.Module;
import com.eduford.www.enums.DifficultyLevel;
import com.eduford.www.enums.Type;
import com.eduford.www.service.McqService;
import com.eduford.www.service.ModuleService;
import com.eduford.www.exception.ResourceNotFoundException;
import com.eduford.www.repository.McqRepository;
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
        optionalModule.ifPresent(mcq::setModule);
        mcq.setQuestion(mcqDto.getQuestion());
        mcq.setImage(mcqDto.getImage());
        mcq.setExplanation(mcqDto.getExplanation());
        mcq.setType(Type.valueOfType(mcqDto.getType()));
        mcq.setDifficultyLevel(DifficultyLevel.valueOfLevel(mcqDto.getDifficultyLevel()));

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

    @PutMapping("")
    public Mcq update(@RequestBody McqDto mcqDto){
        Mcq exixtingMcq = mcqRepository.findById(mcqDto.getId()).orElseThrow(() ->
                new ResourceNotFoundException("MCQ","ID",mcqDto.getId()));
        Optional<Module> optionalModule = moduleService.find(mcqDto.getModuleId());
        optionalModule.ifPresent(exixtingMcq::setModule);
        exixtingMcq.setQuestion(mcqDto.getQuestion());
        exixtingMcq.setImage(mcqDto.getImage());
        exixtingMcq.setExplanation(mcqDto.getExplanation());
        exixtingMcq.setType(Type.valueOfType(mcqDto.getType()));
        exixtingMcq.setDifficultyLevel(DifficultyLevel.valueOfLevel(mcqDto.getDifficultyLevel()));

        return mcqService.update(exixtingMcq);
    }

    @GetMapping("/type")
    public Type[] findType () { return Type.values();}

    @GetMapping("/difficulty-level")
    public DifficultyLevel[] findDifficultyLevel () { return DifficultyLevel.values();}

    @GetMapping("/difficulty/{difficultyLevel}")
    public List<Mcq> getMcqByDifficultyLevel(@PathVariable(value = "difficultyLevel") int difficultyLevel){
        return mcqService.getMcqByDifficultyLevel(DifficultyLevel.valueOfLevel(difficultyLevel));
    }
    @GetMapping("/module/{id}/difficulty/{difficultyLevel}")
    public List<Mcq> getMcqByModuleIdAndDifficultyLevel(@PathVariable(value = "id") Long id,@PathVariable(value = "difficultyLevel") int difficultyLevel){
        return mcqService.getMcqByModuleIdAndDifficultyLevel(id,DifficultyLevel.valueOfLevel(difficultyLevel));
    }
    @GetMapping("/module/{id}")
    public List<Mcq> getMcqByModuleId(@PathVariable(value = "id") Long id){
        return mcqService.getMcqByModuleId(id);
    }
}