package com.lgcns.inspire_restjpa.blog.domain.dto;

import java.util.List;

import com.lgcns.inspire_restjpa.blog.domain.entity.BlogEntity;
import com.lgcns.inspire_restjpa.comment.domain.entity.CommentEntity;

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
public class BlogResponseDTO {
    private Integer blogId;
    private String title;
    private String content;
    private String authorEmail;

    private List<String> comments;

    public static BlogResponseDTO fromEntity(BlogEntity blog){
        return BlogResponseDTO.builder()
                .blogId(blog.getBlogId())
                .title(blog.getTitle())
                .content(blog.getContent())
                .authorEmail("")
                .comments(
                    //blog.getComments()
                    blog.getComments().stream()
                        .map(CommentEntity::getComment)
                        .toList()
                )
                .build();
    }
}
