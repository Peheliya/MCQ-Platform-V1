package com.eduford.www.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_TEST")
public class UserTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "TEST_ID", nullable = false)
    private Test testId;

    @Column(name = "FEEDBACK", nullable = false)
    private String feedback;
}
