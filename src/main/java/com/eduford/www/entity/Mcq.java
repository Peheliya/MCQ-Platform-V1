package com.eduford.www.entity;

import com.eduford.www.enums.DifficultyLevel;
import com.eduford.www.enums.Type;
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
