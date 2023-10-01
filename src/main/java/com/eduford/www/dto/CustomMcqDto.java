package com.eduford.www.dto;

import com.eduford.www.enums.DifficultyLevel;
import com.eduford.www.enums.Type;
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
