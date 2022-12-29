package com.todolist.signup;

import com.todolist.dto.LoginDto;
import com.todolist.dto.SignUpDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SignUpService {

    ResponseEntity<String> addUserDetails(SignUpDto signUpDto);

    ResponseEntity<Object> loginUser(LoginDto loginDto);

}
