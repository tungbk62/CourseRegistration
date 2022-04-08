package com.example.project_demo.service.impl;

import com.example.project_demo.dto.Role;
import com.example.project_demo.dto.SecurityPayload.*;
import com.example.project_demo.dto.UserDTO;
import com.example.project_demo.entity.RoleEntity;
import com.example.project_demo.entity.UserEntity;
import com.example.project_demo.mapper.UserMapper;
import com.example.project_demo.repository.RoleRepository;
import com.example.project_demo.repository.UserRepository;
import com.example.project_demo.security.JwtTokenProvider;
import com.example.project_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Override
    public ResponseEntity<?> signin(SigninRequest signinRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signinRequest.getUsername(),
                        signinRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @Override
    public ResponseEntity<?> signup(SignupRequest signupRequest) {
        RoleEntity userRole;
        if(userRepository.existsByUsername(signupRequest.getUsername())){
            return new ResponseEntity(new ApiRespone(false, "username already exits"), HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(signupRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        userEntity.setStatus(1);

        if(signupRequest.getTypeOfUser() == 1){
            userRole = roleRepository.findByName(Role.ROLE_TEACHER)
                    .orElseThrow(() -> new AppException("User Role not set."));
        }else {
            userRole = roleRepository.findByName(Role.ROLE_STUDENT)
                    .orElseThrow(() -> new AppException("User Role not set."));
        }

        userEntity.setRoles(Collections.singleton(userRole));

        userRepository.save(userEntity);

        return new ResponseEntity(new ApiRespone(true, "Registered successfully"), HttpStatus.OK);
    }

    @Override
    public List<UserDTO> findAll(){
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for(UserEntity i : userEntities){
            userDTOs.add(userMapper.toUserDTO(i));
        }
        return userDTOs;
    }

}
