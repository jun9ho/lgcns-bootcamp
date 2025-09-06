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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequestDTO {
    
    @Schema(description = "유저 이메일", example = "asdf@naver.com")
    private String email;
    @Schema(description = "유저 비밀번호", example = "1234")
    private String passwd;
    @Schema(description = "유저 이름", example = "고길동")
    private String name;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .email(this.email)
                .passwd(this.passwd)
                .name(this.name)
                .build();
    }
}
