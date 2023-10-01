package com.eduford.www.dto;

import com.eduford.www.enums.Type;
import lombok.Data;

@Data
public class CustomAnswerDto {
    private Long answerId;
    private String answer;
    private Boolean isCorrect;
    private Type type;

}
