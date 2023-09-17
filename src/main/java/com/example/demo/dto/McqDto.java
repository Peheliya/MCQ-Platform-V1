package com.example.demo.dto;

import com.example.demo.enums.DifficultyLevel;
import com.example.demo.enums.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class McqDto {
    private Long id;
    private Long moduleId;
    private String question;
    private String explanation;
    //@Enumerated(EnumType.STRING)
    private int type;
    //@Enumerated(EnumType.STRING)
    private int difficultyLevel;
}
