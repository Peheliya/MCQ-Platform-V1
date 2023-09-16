package com.example.demo.controller;

import com.example.demo.dto.AnswerDto;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Mcq;
import com.example.demo.enums.Type;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.service.AnswerService;
import com.example.demo.service.McqService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/answer")
public class AnswerController {

    private McqService mcqService;
    private AnswerRepository answerRepository;
    private final AnswerService answerService;

    public AnswerController(McqService mcqService, AnswerRepository answerRepository, AnswerService answerService) {
        this.mcqService = mcqService;
        this.answerRepository = answerRepository;
        this.answerService = answerService;
    }

    @PostMapping("")
    public Answer save(@RequestBody AnswerDto answerDto){
        Answer answer = new Answer();
        answer.setAnswer(answerDto.getAnswer());
        answer.setIsCorrect(answerDto.getIsCorrect());
        answer.setType(answerDto.getType());
        System.out.println(answerDto);
        Optional<Mcq> optionalMcq = mcqService.find(answerDto.getMcqId());
        if(optionalMcq.isPresent()){
            answer.setMcqId(optionalMcq.get());
        }
        return answerService.save(answer);
    }

    @GetMapping("/{id}")
    public Optional<Answer> getById(@PathVariable(value = "id") Long id){
        return answerService.find(id);
    }

    @GetMapping("")
    public List<Answer> getAll(){
        return answerService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        answerService.delete(id);
    }

    //@DeleteMapping("/answer")
    //public void deleteAll(){        answerService.deleteAll();    }

    @GetMapping("/count")
    public long count(){
        return answerService.count();
    }

    @PutMapping("")
    public Answer update(@RequestBody AnswerDto answerDto){
        Answer existingAnswer = answerRepository.findById(answerDto.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Answer","ID",answerDto.getId()));
        existingAnswer.setAnswer(answerDto.getAnswer());
        existingAnswer.setIsCorrect(answerDto.getIsCorrect());
        existingAnswer.setType(answerDto.getType());
        Optional<Mcq> optionalMcq = mcqService.find(answerDto.getMcqId());
        if(optionalMcq.isPresent()){
            existingAnswer.setMcqId(optionalMcq.get());
        }
        return answerService.update(existingAnswer);
    }

    @GetMapping("/type")
    public Type[] findType () { return Type.values();}
}