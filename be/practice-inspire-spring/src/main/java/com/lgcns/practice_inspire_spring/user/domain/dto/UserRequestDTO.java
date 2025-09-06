package com.lgcns.practice_inspire_spring.user.domain.dto;

import com.lgcns.practice_inspire_spring.user.domain.entity.UserEntity;

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
    
    private String email;
    private String passwd;
    private String name;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .email(this.email)
                .passwd(this.passwd)
                .name(this.name)
                .build();
    }
}
