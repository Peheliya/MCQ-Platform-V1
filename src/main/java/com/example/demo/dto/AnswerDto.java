package com.example.demo.dto;

import com.example.demo.enums.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AnswerDto {
    private Long id;
    private String answer;
    private Boolean isCorrect;
    @Enumerated(EnumType.STRING)
    private Type type;
    private Long mcqId;
}
