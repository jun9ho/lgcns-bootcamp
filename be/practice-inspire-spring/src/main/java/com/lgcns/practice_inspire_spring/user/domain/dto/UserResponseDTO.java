package com.lgcns.practice_inspire_spring.user.domain.dto;

import com.lgcns.practice_inspire_spring.user.domain.entity.UserEntity;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "유저 이메일", example = "asdf@naver.com")
    private String email;
    @Schema(description = "유저 비밀번호", example = "1234")
    private String passwd;
    @Schema(description = "유저 이름", example = "고길동")
    private String name;
    
    public static UserResponseDTO fromEntity(UserEntity user){
        return UserResponseDTO.builder()
                .email(user.getEmail())
                .passwd(user.getPasswd())
                .name(user.getName())
                .build();
    }
}
