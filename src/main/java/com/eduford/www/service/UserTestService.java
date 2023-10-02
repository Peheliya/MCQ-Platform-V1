package com.eduford.www.service;

import com.eduford.www.entity.UserTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface UserTestService {

    UserTest save(UserTest usertest);

    Optional<UserTest> find(Long id);

    List<UserTest> findAll();

    List<UserTest> findAll(Sort sort);

    Page<UserTest> findAll(Pageable pageable);

    void delete(Long id);

    void delete(UserTest usertest);

    void deleteAll();

    long count();

    UserTest update(UserTest usertest);

}