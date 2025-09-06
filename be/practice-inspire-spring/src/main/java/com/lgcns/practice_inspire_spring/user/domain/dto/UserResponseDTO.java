package com.lgcns.practice_inspire_spring.user.domain.dto;

import com.lgcns.practice_inspire_spring.user.domain.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseDTO {
    private String email;
    private String passwd;
    private String name;

    public static UserResponseDTO fromEntity(UserEntity user){
        return UserResponseDTO.builder()
                .email(user.getEmail())
                .passwd(user.getPasswd())
                .name(user.getName())
                .build();
    }
}
