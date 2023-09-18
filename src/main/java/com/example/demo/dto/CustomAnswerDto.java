package com.example.demo.dto;

import com.example.demo.enums.Type;
import lombok.Data;

@Data
public class CustomAnswerDto {
    private Long answerId;
    private String answer;
    private Boolean isCorrect;
    private Type type;

}
