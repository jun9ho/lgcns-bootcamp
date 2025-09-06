package com.lgcns.practice_inspire_spring.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgcns.practice_inspire_spring.user.domain.dto.UserRequestDTO;
import com.lgcns.practice_inspire_spring.user.domain.dto.UserResponseDTO;
import com.lgcns.practice_inspire_spring.user.domain.entity.UserEntity;
import com.lgcns.practice_inspire_spring.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponseDTO signup(UserRequestDTO request) {
        System.out.println(">>> service singup");
        UserEntity entity = userRepository.save(request.toEntity());
        return UserResponseDTO.fromEntity(entity);
    }

    public UserResponseDTO signin(UserRequestDTO request) {
        System.out.println(">>> service singin");
        UserEntity entity = userRepository.findByEmailAndPasswd(request.getEmail(), request.getPasswd());
        return UserResponseDTO.fromEntity(entity);
    }
    
}
