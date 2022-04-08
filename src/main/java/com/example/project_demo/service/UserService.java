package com.example.project_demo.service;

import com.example.project_demo.dto.SecurityPayload.SigninRequest;
import com.example.project_demo.dto.SecurityPayload.SignupRequest;
import com.example.project_demo.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<?> signin(SigninRequest signinRequest);
    ResponseEntity<?> signup(SignupRequest signupRequest);
    List<UserDTO> findAll();
}
