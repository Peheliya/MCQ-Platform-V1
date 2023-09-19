package com.example.demo.controller;

import com.example.demo.dto.BookmarkDto;
import com.example.demo.entity.Bookmark;
import com.example.demo.entity.Test;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BookmarkRepository;
import com.example.demo.service.BookmarkService;
import com.example.demo.service.TestService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/bookmark")
public class BookmarkController {

    private final BookmarkService bookmarkService;
    private final UserService userService;
    private final TestService testService;
    private final BookmarkRepository bookmarkRepository;

    public BookmarkController(BookmarkService bookmarkService, UserService userService, TestService testService, BookmarkRepository bookmarkRepository) {
        this.bookmarkService = bookmarkService;
        this.userService = userService;
        this.testService = testService;
        this.bookmarkRepository = bookmarkRepository;
    }

    @PostMapping("")
    public Bookmark save(@RequestBody BookmarkDto bookmarkDto){
        Bookmark bookmark = new Bookmark();
        Optional<User> optionalUser = userService.find(bookmarkDto.getStudentId());
        if(optionalUser.isPresent()){
            bookmark.setStudentId(optionalUser.get());
        }
        Optional<Test> optionalTest = testService.find(bookmarkDto.getTestId());
        if (optionalTest.isPresent()){
            bookmark.setTestId(optionalTest.get());
        }
        return bookmarkService.save(bookmark);
    }

    @GetMapping("/{id}")
    public Optional<Bookmark> getById(@PathVariable(value = "id") Long id){
        return bookmarkService.find(id);
    }

    @GetMapping("")
    public List<Bookmark> getAll(){
        return bookmarkService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        bookmarkService.delete(id);
    }

    //@DeleteMapping("/bookmark")
    //public void deleteAll(){        bookmarkService.deleteAll();    }

    @GetMapping("/count")
    public long count(){
        return bookmarkService.count();
    }

    @PutMapping
    public Bookmark update(BookmarkDto bookmarkDto){
        Bookmark existingBookmark = bookmarkRepository.findById(bookmarkDto.getId()).orElseThrow(()->
                new ResourceNotFoundException("Bookmark","ID",bookmarkDto.getId()));
        Optional<User> optionalUser = userService.find(bookmarkDto.getStudentId());
        if(optionalUser.isPresent()){
            existingBookmark.setStudentId(optionalUser.get());
        }
        Optional<Test> optionalTest = testService.find(bookmarkDto.getTestId());
        if (optionalTest.isPresent()){
            existingBookmark.setTestId(optionalTest.get());
        }
        return bookmarkService.save(existingBookmark);
    }
}