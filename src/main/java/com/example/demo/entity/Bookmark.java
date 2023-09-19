package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "BOOKMARK")
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    private User studentId;

    @ManyToOne
    @JoinColumn(name = "TEST_ID", nullable = false)
    private Test testId;
}
