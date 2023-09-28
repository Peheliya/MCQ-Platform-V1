package com.example.demo.dto;

import lombok.Data;

@Data
public class McqDto {
    private Long id;
    private Long moduleId;
    private String question;
    private String image;
    private String explanation;
    //@Enumerated(EnumType.STRING)
    private int type;
    //@Enumerated(EnumType.STRING)
    private int difficultyLevel;
}
