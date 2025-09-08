package com.lgcns.practice_inspire_spring.blog.domain.dto;

import com.lgcns.practice_inspire_spring.blog.domain.entity.BlogEntity;

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
public class BlogResponseDTO {

    private int blogId;
    private String title;
    private String content;
    private String authorEmail;

    public static BlogResponseDTO fromEntity(BlogEntity blog){
        return BlogResponseDTO.builder()
                    .blogId(blog.getBlogId())
                    .title(blog.getTitle())
                    .content(blog.getContent())
                    .authorEmail(blog.getAuthor().getEmail())
                    .build();
    }
}
