package com.example.demo.entity;

import com.example.demo.enums.DifficultyLevel;
import com.example.demo.enums.Type;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MCQ")
public class Mcq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MODULE_ID", nullable = false)
    private Module module;

    @Column(name = "QUESTION", nullable = false)
    private String question;

    @Column(name = "IMAGE", nullable = false)
    private String image;

    @Column(name = "EXPLANATION")
    private String explanation;

    @Column(name = "TYPE",length = 10)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "DIFFICULTY_LEVEL",length = 20)
    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;
}
