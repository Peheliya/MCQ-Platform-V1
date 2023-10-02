package com.eduford.www.controller;

import com.eduford.www.dto.ExamDto;
import com.eduford.www.entity.Exam;
import com.eduford.www.entity.Subject;
import com.eduford.www.enums.Type;
import com.eduford.www.exception.ResourceNotFoundException;
import com.eduford.www.service.ExamService;
import com.eduford.www.service.SubjectService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/exam")
public class ExamController {

    private final ExamService examService;
    private final SubjectService subjectService;
    public ExamController(ExamService examService, SubjectService subjectService) {
        this.examService = examService;
        this.subjectService = subjectService;
    }

    @PostMapping("")
    public Exam save(@RequestBody ExamDto examDto){
        Exam exam = new Exam();
        exam.setName(examDto.getName());
        exam.setType(examDto.getType());
        Optional<Subject> optionalSubject = subjectService.find(examDto.getSubjectId());
        optionalSubject.ifPresent(exam::setSubjectId);
        return examService.save(exam);
    }

    @GetMapping("/{id}")
    public Optional<Exam> getById(@PathVariable(value = "id") Long id){
        return examService.find(id);
    }

    @GetMapping("")
    public List<Exam> getAll(){
        return examService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        examService.delete(id);
    }

    //@DeleteMapping("/exam")
    //public void deleteAll(){        examService.deleteAll();    }

    @GetMapping("/count")
    public long count(){
        return examService.count();
    }

    @PutMapping("")
    public Exam update(@RequestBody ExamDto examDto){
        Exam existingExam = examService.find(examDto.getId()).orElseThrow(()->
                new ResourceNotFoundException("Exam","ID",examDto.getId()));
        existingExam.setName(examDto.getName());
        existingExam.setType(examDto.getType());
        Optional<Subject> optionalSubject = subjectService.find(examDto.getSubjectId());
        optionalSubject.ifPresent(existingExam::setSubjectId);
        return examService.update(existingExam);
    }

    @GetMapping("type/{type1}")
    public List<Exam> getExamByType(@PathVariable(value = "type1") Type type2){
        return examService.getExamByType(type2);
    }
}