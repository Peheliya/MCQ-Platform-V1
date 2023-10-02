package com.eduford.www.dto;
import com.eduford.www.enums.Type;
import lombok.Data;

@Data
public class ExamDto {
    private Long id;
    private String name;
    private Long subjectId;
    private Type type;
}
