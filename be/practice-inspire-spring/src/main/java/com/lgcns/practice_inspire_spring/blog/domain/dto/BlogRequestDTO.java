package com.lgcns.practice_inspire_spring.blog.domain.dto;

import com.lgcns.practice_inspire_spring.blog.domain.entity.BlogEntity;
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
public class BlogRequestDTO {
    
    @Schema(description="블로그 제목", example = "안녕하세요." )
    private String title;
    @Schema(description="블로그 내용", example = "반갑습니다.")
    private String content;
    ///FK
    private String authorEmail;

    public BlogEntity toEntity(UserEntity author){
        return BlogEntity.builder()
                .title(this.title)
                .content(this.content)
                .author(author)
                .build();
    }
}
