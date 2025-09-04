package com.lgcns.inspire_restjpa.blog.domain.dto;

import com.lgcns.inspire_restjpa.blog.domain.entity.BlogEntity;
import com.lgcns.inspire_restjpa.user.domain.entity.UserEntity;

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
public class BlogRequestDTO {
    private String title;
    private String content;
    ///FK
    private String authorEmail;

    public BlogEntity toEntity(UserEntity author){
        return BlogEntity.builder()
                .title(null)
                .content(null)
                .author(author)
                .build();
    }
}
