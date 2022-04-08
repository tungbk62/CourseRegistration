package com.example.project_demo.controller;

import com.example.project_demo.dto.SecurityPayload.SigninRequest;
import com.example.project_demo.dto.SecurityPayload.SignupRequest;
import com.example.project_demo.dto.UserDTO;
import com.example.project_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/auth")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/signup")
    ResponseEntity<?> signup(@Valid @RequestBody SignupRequest signupRequest){
        return userService.signup(signupRequest);
    }

    @PostMapping(value = "/signin")
    ResponseEntity<?> signin(@Valid @RequestBody SigninRequest signinRequest){
        return userService.signin(signinRequest);
    }

}
