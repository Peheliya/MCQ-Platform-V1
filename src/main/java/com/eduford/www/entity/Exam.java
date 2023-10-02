package com.eduford.www.entity;

import com.eduford.www.enums.Type;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EXAMS")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID", nullable = false)
    private Subject subjectId;

    @Column(name = "TYPE",length = 10)
    @Enumerated(EnumType.STRING)
    private Type type;
}
