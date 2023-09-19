package com.example.demo.service.impl;

import com.example.demo.entity.Bookmark;
import com.example.demo.repository.BookmarkRepository;
import com.example.demo.service.BookmarkService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @Override
    public Bookmark save(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }

    @Override
    public Optional<Bookmark> find(Long id) {
        return bookmarkRepository.findById(id);
    }

    @Override
    public List<Bookmark> findAll() {
        return bookmarkRepository.findAll();
    }

    @Override
    public List<Bookmark> findAll(Sort sort){
        return bookmarkRepository.findAll(sort);
    }

    @Override
    public Page<Bookmark> findAll(Pageable pageable){
        return bookmarkRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    bookmarkRepository.deleteById(id);
    }

    @Override
    public void delete(Bookmark bookmark) {
        bookmarkRepository.delete(bookmark);
    }

    //@Override
    //public void deleteAll() {        bookmarkRepository.deleteAll();    }

    @Override
    public long count() {
        return bookmarkRepository.count();
    }

    @Override
    public Bookmark update(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }

}