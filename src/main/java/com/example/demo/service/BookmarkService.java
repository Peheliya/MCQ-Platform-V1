package com.example.demo.service;

import com.example.demo.entity.Bookmark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface BookmarkService {

    Bookmark save(Bookmark bookmark);

    Optional<Bookmark> find(Long id);

    List<Bookmark> findAll();

    List<Bookmark> findAll(Sort sort);

    Page<Bookmark> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Bookmark bookmark);

    //void deleteAll();

    long count();

    Bookmark update(Bookmark bookmark);
}