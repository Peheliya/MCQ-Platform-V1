package com.example.demo.entity;

import com.example.demo.service.AnswerService;
import com.example.demo.service.McqService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/answer")
public class Question {
//    private Optional<Mcq> mcq;
//    private List<Answer> answers;
//    private final AnswerService answerService;
//    private final McqService mcqService;
//
//    public Question(AnswerService answerService, McqService mcqService) {
//        this.mcqService = mcqService;
//        this.answerService = answerService;
//        this.mcq = this.mcqService.find();
//        if (mcq.isPresent()){
//            this.answers = this.answerService.getAnswerByMcqId(mcq.get().getId());
//        }
//    }
}
