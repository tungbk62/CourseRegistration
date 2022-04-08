package com.example.project_demo.mapper;

import com.example.project_demo.dto.UserDTO;
import com.example.project_demo.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(UserEntity userEntity);
    UserEntity toUserEntity(UserDTO userDTO);
}
