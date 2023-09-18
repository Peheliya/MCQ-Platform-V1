package com.example.demo.controller;

import com.example.demo.dto.CustomMcqDto;
import com.example.demo.service.CustomMcqDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/custommcq")
public class CustomMcqDtoController {
    @Autowired
    private CustomMcqDtoService customMcqDtoService;

    @GetMapping("/{mcqId}")
    public ResponseEntity<CustomMcqDto> getCustomMcqDto(@PathVariable Long mcqId) {
        CustomMcqDto customMcqDto = customMcqDtoService.createCustomMcqDto(mcqId);
        if (customMcqDto != null) {
            return ResponseEntity.ok(customMcqDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
