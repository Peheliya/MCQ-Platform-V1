package com.eduford.www.controller;

import com.eduford.www.dto.CustomMcqDto;
import com.eduford.www.service.CustomMcqDtoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/custommcq")
public class CustomMcqDtoController {
    private final CustomMcqDtoService customMcqDtoService;

    public CustomMcqDtoController(CustomMcqDtoService customMcqDtoService) {
        this.customMcqDtoService = customMcqDtoService;
    }

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
