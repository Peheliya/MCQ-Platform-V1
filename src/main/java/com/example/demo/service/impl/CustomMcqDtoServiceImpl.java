package com.example.demo.service.impl;

import com.example.demo.dto.CustomAnswerDto;
import com.example.demo.dto.CustomMcqDto;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Mcq;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.McqRepository;
import com.example.demo.service.CustomMcqDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomMcqDtoServiceImpl implements CustomMcqDtoService {

    @Autowired
    private McqRepository mcqRepository;

    @Autowired
    private AnswerRepository answerRepository;
    @Override
    public CustomMcqDto createCustomMcqDto(Long mcqId) {
        Mcq mcq = mcqRepository.findById(mcqId).orElse(null);
        if (mcq == null) {
            //new ResourceNotFoundException("MCQ","ID",mcq.getId());
            return null;
        }

        List<Answer> answers = answerRepository.getAnswerByMcqId(mcq.getId());

        // Create a new CustomMcqDto and populate it with data from Mcq and Answer entities
        CustomMcqDto customMcqDto = new CustomMcqDto();
        customMcqDto.setMcqId(mcq.getId());
        customMcqDto.setMcqQuestion(mcq.getQuestion());
        customMcqDto.setDifficultyLevel(mcq.getDifficultyLevel());
        customMcqDto.setType(mcq.getType());
        customMcqDto.setExplanation(mcq.getExplanation());

        // Create a list of CustomAnswerDto objects
        List<CustomAnswerDto> customAnswerDtos = new ArrayList<>();
        for (Answer answer : answers) {
            CustomAnswerDto customAnswerDto = new CustomAnswerDto();
            customAnswerDto.setAnswerId(answer.getId());
            customAnswerDto.setAnswer(answer.getAnswer());
            customAnswerDto.setIsCorrect(answer.getIsCorrect());
            customAnswerDto.setType(answer.getType());
            customAnswerDtos.add(customAnswerDto);
        }
        customMcqDto.setAnswers(customAnswerDtos);

        return customMcqDto;
    }
}
