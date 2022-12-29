package com.todolist.signup;

import com.todolist.dto.LoginDto;
import com.todolist.dto.SignUpDto;
import com.todolist.entity.SignUp;
import com.todolist.repository.SignUpRepository;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final Mapper mapper = new DozerBeanMapper();
    @Autowired
    private SignUpRepository signUpRepository;

    @Override
    @Transactional
    public ResponseEntity<String> addUserDetails(SignUpDto signUpDto) {

        Optional<SignUp> signUp = signUpRepository.findByDisplayName(signUpDto.getDisplayName());

        if (signUp.isEmpty()) {
            SignUp userDetails = mapper.map(signUpDto, SignUp.class);
            signUpRepository.save(userDetails);
            return ResponseEntity.ok("Signed Up Successfully");
        }

        return new ResponseEntity<>("Display Name Already Present", HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<Object> loginUser(LoginDto loginDto) {

        Optional<SignUp> userDetails = signUpRepository.findByName(loginDto.getUserName());

        if (userDetails.isPresent()) {
            SignUp signUp = userDetails.get();
            if (signUp.getPassword().equals(loginDto.getPassword())) {
                LoginDto login = new LoginDto();
                login.setUserId(signUp.getId());
                login.setUserName(signUp.getName());

                return new ResponseEntity<>(login, HttpStatus.OK);
            }
            return new ResponseEntity<>("password is incorrect", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>("User not Found", HttpStatus.BAD_REQUEST);
    }
}
