package com.eduford.www.entity;

import com.eduford.www.enums.DifficultyLevel;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Test1")
public class Test {
    //This is a temp file by Peheliya. Replace this by Dinali's file

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "MODULE_ID", nullable = false)
    private Module module;

    @Column(name = "DIFFICULTY_LEVEL",length = 20)
    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;
}
