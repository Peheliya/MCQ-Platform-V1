package com.example.demo.dto;

import com.example.demo.enums.DifficultyLevel;
import com.example.demo.enums.Type;
import lombok.Data;

import java.util.List;

@Data
public class CustomMcqDto {
    private Long mcqId;
    private String mcqQuestion;
    private DifficultyLevel difficultyLevel;
    private Type type;
    private String explanation;
    private List<CustomAnswerDto> answers;
}
