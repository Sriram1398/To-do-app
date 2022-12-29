package com.todolist.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginDto {

    private Long userId;

    @NotEmpty(message = "Please Provide UserName")
    private String userName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotEmpty(message = "Please Provide password")
    private String password;
}
