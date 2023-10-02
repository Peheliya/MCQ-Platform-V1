package com.eduford.www.dto;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Integer userType;
    private Integer userStatus;
}
