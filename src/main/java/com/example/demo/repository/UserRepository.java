package com.example.demo.repository;

import com.example.demo.entity.Mcq;
import com.example.demo.entity.User;
import com.example.demo.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM USERS WHERE users.type = UPPER(:#{#userType?.toString()}) ", nativeQuery = true)
    List<User> getUserByUserType(@Param("userType") UserType userType);
}