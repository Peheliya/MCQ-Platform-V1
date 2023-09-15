package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MODULE")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID", nullable = false)
    private Subject subject;
}
