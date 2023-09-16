package com.example.demo.entity;

import com.example.demo.enums.Type;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ANSWER")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ANSWER", nullable = false)
    private String answer;

    @Column(name = "IS_CORRECT", nullable = false)
    private Boolean isCorrect;

    @Column(name = "TYPE",length = 10)
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "MCQ_ID")
    private Mcq mcqId;
}
