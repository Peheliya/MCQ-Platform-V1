package com.eduford.www.service.impl;

import com.eduford.www.dto.CustomAnswerDto;
import com.eduford.www.dto.CustomMcqDto;
import com.eduford.www.entity.Answer;
import com.eduford.www.entity.Mcq;
import com.eduford.www.repository.AnswerRepository;
import com.eduford.www.repository.McqRepository;
import com.eduford.www.service.CustomMcqDtoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomMcqDtoServiceImpl implements CustomMcqDtoService {

    private final McqRepository mcqRepository;

    private final AnswerRepository answerRepository;

    public CustomMcqDtoServiceImpl(McqRepository mcqRepository, AnswerRepository answerRepository) {
        this.mcqRepository = mcqRepository;
        this.answerRepository = answerRepository;
    }

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
