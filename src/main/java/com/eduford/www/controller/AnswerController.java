package com.eduford.www.controller;

import com.eduford.www.entity.Answer;
import com.eduford.www.entity.Mcq;
import com.eduford.www.enums.Type;
import com.eduford.www.service.AnswerService;
import com.eduford.www.service.McqService;
import com.eduford.www.dto.AnswerDto;
import com.eduford.www.exception.ResourceNotFoundException;
import com.eduford.www.repository.AnswerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/answer")
public class AnswerController {

    private final McqService mcqService;
    private final AnswerRepository answerRepository;
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
        answer.setImage(answerDto.getImage());
        answer.setIsCorrect(answerDto.getIsCorrect());
        answer.setType(Type.valueOfType(answerDto.getType()));
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
        existingAnswer.setImage(answerDto.getImage());
        existingAnswer.setIsCorrect(answerDto.getIsCorrect());
        existingAnswer.setType(Type.valueOfType(answerDto.getType()));
        Optional<Mcq> optionalMcq = mcqService.find(answerDto.getMcqId());
        if(optionalMcq.isPresent()){
            existingAnswer.setMcqId(optionalMcq.get());
        }
        return answerService.update(existingAnswer);
    }

    @GetMapping("/type")
    public Type[] findType () { return Type.values();}

    @GetMapping("/mcq/{id}")
    public List<Answer> getAnswerByMcqId(@PathVariable(value = "id") Long id){
        return answerService.getAnswerByMcqId(id);
    }


}