package com.example.demo.entity;

import com.example.demo.enums.UserStatus;
import com.example.demo.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "TYPE",length = 10)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "STATUS",length = 20)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
}
