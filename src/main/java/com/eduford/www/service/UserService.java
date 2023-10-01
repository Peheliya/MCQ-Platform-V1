package com.eduford.www.service;

import com.eduford.www.entity.User;
import com.eduford.www.enums.UserType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> find(Long id);

    List<User> findAll();

    List<User> findAll(Sort sort);

    Page<User> findAll(Pageable pageable);

    void delete(Long id);

    void delete(User user);

    //void deleteAll();

    long count();

    User update(User user);

    List<User> getUserByUserType(UserType userType);
}