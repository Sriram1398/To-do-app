package com.todolist.signup;

import com.todolist.dto.LoginDto;
import com.todolist.dto.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SignUpController {


    @Autowired
    private SignUpService signUpService;

    @GetMapping("/home")
    public String displayMsg() {
        return "Welcome to Interactive To do list App";
    }

    @PostMapping("/signUp")
    public ResponseEntity<String> registerUserDetails( @Valid  @RequestBody SignUpDto signUpDto) {

        return signUpService.addUserDetails(signUpDto);
    }

    @PostMapping("/login")
    public  ResponseEntity<Object> loginUser(@Valid @RequestBody LoginDto loginDto ){
        return signUpService.loginUser(loginDto);
    }

}
