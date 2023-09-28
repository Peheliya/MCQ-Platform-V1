package com.example.demo.dto;

import lombok.Data;

@Data
public class AnswerDto {
    private Long id;
    private String answer;
    private String image;
    private Boolean isCorrect;
    //@Enumerated(EnumType.STRING)
    private int type;
    private Long mcqId;
}
