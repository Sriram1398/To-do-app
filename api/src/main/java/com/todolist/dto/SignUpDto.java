package com.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {

    @NotBlank(message = "Name is must,Please Provide name of the User")
    private String name;
    @NotBlank(message = "Display Name is Required to show it in the App")
    private String displayName;
    @NotBlank(message = "Password should be provided for creating a new account")
    private String password;
    @Pattern(regexp = "^(.+)@(.+)$", message = "Not a valid email Id")
    private String email;
}

