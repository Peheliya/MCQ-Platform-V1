package com.eduford.www.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SUBJECT")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

}
